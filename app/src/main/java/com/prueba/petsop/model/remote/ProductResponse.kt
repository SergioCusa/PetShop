package com.prueba.petsop.model.remote

import com.prueba.petsop.model.Product

data class ProductResponse(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int
)