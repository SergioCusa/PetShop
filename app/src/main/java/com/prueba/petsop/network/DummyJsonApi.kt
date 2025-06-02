package com.prueba.petsop.network

import com.prueba.petsop.model.remote.ProductResponse
import retrofit2.http.GET

interface DummyJsonApi {
    @GET("products")
    suspend fun getProducts(): ProductResponse

    @GET("products/{id}")
    suspend fun getProduct(id: Int): ProductResponse
}