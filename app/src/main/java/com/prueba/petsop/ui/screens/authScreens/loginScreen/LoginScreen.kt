package com.prueba.petsop.ui.screens.authScreens.loginScreen

import AuthSocialButtonWithImage
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.buttons.PrimaryButton
import com.prueba.petsop.ui.components.text.LinkedTextRow
import com.prueba.petsop.ui.components.text.ValidateTextField
import com.prueba.petsop.viewmodel.LoginResult
import com.prueba.petsop.viewmodel.LoginViewModel

/*"Usuario de prueba: 'emilys'\nContraseña: 'emilyspass'"*/

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotClick: () -> Unit,
    onBackClick: () -> Unit, 
    viewModel: LoginViewModel = viewModel()
) {
    val email by viewModel.username.collectAsState()
    val password by viewModel.password.collectAsState()
    val result by viewModel.result.collectAsState()

    val allValid = email.isNotBlank() && password.isNotBlank()

    BackHandler {
        onBackClick()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            Text(
                text = "Hello,\nWelcome Back!",
                style = MaterialTheme.typography.headlineLarge,
                lineHeight = 40.sp
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Water is life. Water is a basic human need. In various lines of life, humans need water.",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        ValidateTextField(
            value = email,
            onValueChange = {
                viewModel.username.value = it
                viewModel.clearResult()
            },
            placeholder = "Email",
            showError = email.isEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

        ValidateTextField(
            value = password,
            onValueChange = {
                viewModel.password.value = it
                viewModel.clearResult()
            },
            placeholder = "Password",
            showError = password.isEmpty()
        )

        Spacer(modifier = Modifier.height(50.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            AuthSocialButtonWithImage(
                text = "Google",
                iconResId = R.drawable.google_icon,
                onClick = {},
                modifier = Modifier.weight(1f)
            )
            AuthSocialButtonWithImage(
                text = null,
                iconResId = R.drawable.facebook_icon,
                onClick = {},
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        when (result) {
            is LoginResult.Success -> {
                val response = (result as LoginResult.Success).response
                Text("Bienvenido: ${response.username}", color = MaterialTheme.colorScheme.primary)
            }
            is LoginResult.Error -> {
                Text(
                    text = (result as LoginResult.Error).message,
                    color = MaterialTheme.colorScheme.error
                )
            }
            LoginResult.None -> {}
        }

        Spacer(modifier = Modifier.height(24.dp))

        LinkedTextRow(
            normalText = "Don’t have an account?",
            linkText = "Create Account",
            onLinkClick = onRegisterClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        LinkedTextRow(
            normalText = "",
            linkText = "Forgot your password?",
            onLinkClick = onForgotClick
        )

        Spacer(modifier = Modifier.height(32.dp))

        PrimaryButton(
            text = "Get Started",
            enabled = allValid,
            onClick = {
                if (allValid) {
                    viewModel.login()

                }
            }
        )

        LaunchedEffect(result) {
            if (result is LoginResult.Success) {
                onLoginClick()
                viewModel.clearResult()
            }
        }

    }
}
