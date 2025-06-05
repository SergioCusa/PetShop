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
        loadFavorites()
    }

    private fun loadProducts() {
        viewModelScope.launch {
            try {
                _products.value = repository.getProducts()
            } catch (e: Exception) {
                _products.value = emptyList()
            }
        }
    }

    private fun loadFavorites() {
        viewModelScope.launch {
            try {
                repository.getFavoriteProducts().collect { favorites ->
                    _favoriteProducts.value = favorites
                }
            } catch (e: Exception) {
                _favoriteProducts.value = emptyList()
            }
        }
    }

    fun toggleFavorite(product: Product) {
        viewModelScope.launch {
            _products.value = _products.value.map { current ->
                if (current.id == product.id) {
                    current.copy(isFavorite = !current.isFavorite) 
                } else current
            }

            runCatching {
                repository.toggleFavorite(product)
            }

            loadFavorites()
        }
    }
}