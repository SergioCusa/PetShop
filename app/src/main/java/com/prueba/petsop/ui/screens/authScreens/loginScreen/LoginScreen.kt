package com.prueba.petsop.ui.screens.authScreens.loginScreen

import AuthSocialButtonWithImage
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.buttons.PrimaryButton
import com.prueba.petsop.ui.components.text.AuthOutlinedTextField
import com.prueba.petsop.ui.components.text.LinkedTextRow

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    var emailTouched by remember { mutableStateOf(false) }
    var passwordTouched by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
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

        // Inputs
        AuthOutlinedTextField(
            value = email,
            onValueChange = { email = it },
            placeholderText = "Email",
            isError = emailTouched && email.isBlank(),
            errorMessage = "Required Fields",
            showErrorMessage = emailTouched
        )

        Spacer(modifier = Modifier.height(16.dp))

        AuthOutlinedTextField(
            value = password,
            onValueChange = { password = it },
            placeholderText = "Password",
            isError = passwordTouched && password.isBlank(),
            errorMessage = "Required Fields",
            showErrorMessage = passwordTouched
        )

        Spacer(modifier = Modifier.height(50.dp))

        // Botones sociales
        Row(
            modifier = Modifier
                .fillMaxWidth(),
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

        Spacer(modifier = Modifier.height(200.dp))
        // Texto con link
        LinkedTextRow(
            normalText = "Don’t have an account?",
            linkText = "Create Account",
            onLinkClick = { onRegisterClick() }
        )

        Spacer(modifier = Modifier.height(32.dp))

        LinkedTextRow(
            normalText = "",
            linkText = "forgot your password?",
            onLinkClick = { onForgotClick() }
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Botón principal
        PrimaryButton(
            text = "Get Started",
            onClick = {
                emailTouched = true
                passwordTouched = true
                if (email.isNotBlank() && password.isNotBlank()) {
                    onLoginClick()
                }
            },
            enabled = email.isNotBlank() || password.isNotBlank()
        )
    }
}
