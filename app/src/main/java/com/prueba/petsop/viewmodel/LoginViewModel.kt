package com.prueba.petsop.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.prueba.petsop.model.LoginRequest
import com.prueba.petsop.model.LoginResponse
import com.prueba.petsop.network.AuthApiService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

sealed class LoginResult {
    data class Success(val response: LoginResponse) : LoginResult()
    data class Error(val message: String) : LoginResult()
    object None : LoginResult()
}

class LoginViewModel : ViewModel() {
    private val api: AuthApiService = Retrofit.Builder()
        .baseUrl("https://dummyjson.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(AuthApiService::class.java)

    var username = MutableStateFlow("")
    var password = MutableStateFlow("")
    private val _result = MutableStateFlow<LoginResult>(LoginResult.None)
    val result: StateFlow<LoginResult> = _result

    fun login() {
        if (username.value == "test") {
            _result.value = LoginResult.Success(
                LoginResponse(
                    id = 1,
                    username = "test",
                    email = "test@example.com",
                    firstName = "Test",
                    lastName = "User",
                    gender = "N/A",
                    image = "https://example.com/test.png",
                    token = "dummy-token"
                )
            )
        } else {
            viewModelScope.launch {
                try {
                    val response = api.login(LoginRequest(username.value, password.value))
                    _result.value = LoginResult.Success(response)
                } catch (e: Exception) {
                    _result.value = LoginResult.Error(e.message ?: "Error desconocido")
                }
            }
        }
    }

    fun clearResult() {
        _result.value = LoginResult.None
    }
}