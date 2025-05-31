package com.prueba.petsop.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prueba.petsop.model.Product
import com.prueba.petsop.network.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            try {
                val response = RetrofitInstance.api.getProducts()
                _products.value = response.products
            } catch (e: Exception) {
                Log.e("ProductViewModel", "Error fetching products", e)
                _products.value = emptyList()
            }
        }
    }
}