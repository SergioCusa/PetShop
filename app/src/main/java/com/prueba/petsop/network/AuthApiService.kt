package com.prueba.petsop.network

import com.prueba.petsop.model.LoginRequest
import com.prueba.petsop.model.LoginResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApiService {
    @POST("auth/login")
    suspend fun login(@Body request: LoginRequest): LoginResponse
}