package com.prueba.petsop.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prueba.petsop.viewmodel.LoginViewModel
import com.prueba.petsop.viewmodel.LoginResult

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(viewModel: LoginViewModel = viewModel()) {
    val username by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()
    val result by viewModel.result.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Text(
            "Usuario de prueba: 'emilys'\nContraseña: 'emilyspass'",
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(bottom = 16.dp)
        )

        OutlinedTextField(
            value = username,
            onValueChange = {
                viewModel.username.value = it
                viewModel.clearResult()
            },
            label = { Text("Usuario") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = password,
            onValueChange = {
                viewModel.password.value = it
                viewModel.clearResult()
            },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.login() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Iniciar sesión")
        }
        Spacer(modifier = Modifier.height(16.dp))

        // Mostrar el response
        when (result) {
            is LoginResult.Success -> {
                val response = (result as LoginResult.Success).response
                Text("Respuesta: $response", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.height(8.dp))
                Text("¡Login exitoso!", color = MaterialTheme.colorScheme.primary)
            }
            is LoginResult.Error -> {
                Text("Error: ${(result as LoginResult.Error).message}", color = MaterialTheme.colorScheme.error)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Login fallido", color = MaterialTheme.colorScheme.error)
            }
            LoginResult.None -> {}
        }
    }
}