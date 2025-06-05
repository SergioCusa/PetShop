package com.prueba.petsop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prueba.petsop.model.Product
import com.prueba.petsop.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
) : ViewModel() {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    private val _favoriteProducts = MutableStateFlow<List<Product>>(emptyList())
    val favoriteProducts: StateFlow<List<Product>> = _favoriteProducts

    init {
        loadProducts()
        observeFavorites() 
    }

    private fun loadProducts() = viewModelScope.launch {
        _products.value = runCatching { repository.getProducts() }
            .getOrElse { emptyList() }
    }

    private fun observeFavorites() = viewModelScope.launch {
        repository.getFavoriteProducts().collect { favs ->
            _favoriteProducts.value = favs

            val favIds = favs.map { it.id }.toSet()
            _products.value = _products.value.map { p ->
                p.copy(isFavorite = favIds.contains(p.id))
            }
        }
    }

    fun toggleFavorite(product: Product) = viewModelScope.launch {
        _products.value = _products.value.map { cur ->
            if (cur.id == product.id) cur.copy(isFavorite = !cur.isFavorite) else cur
        }
        _favoriteProducts.value =
            if (product.isFavorite)
                _favoriteProducts.value.filterNot { it.id == product.id }
            else
                _favoriteProducts.value + product.copy(isFavorite = true)

        repository.toggleFavorite(product)

    }
}