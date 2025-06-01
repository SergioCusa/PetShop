package com.prueba.petsop.network

import com.prueba.petsop.model.ProductResponse
import retrofit2.http.GET

interface ProductApiService {
    @GET("products")
    suspend fun getProducts(): ProductResponse
}