package com.prueba.petsop.network

import com.prueba.petsop.model.Product

data class ProductResponse(
    val products: List<Product>
)

data class SingleProductResponse(
    val product: Product
)