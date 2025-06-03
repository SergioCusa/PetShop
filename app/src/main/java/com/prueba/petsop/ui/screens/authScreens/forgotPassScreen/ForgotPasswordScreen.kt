package com.prueba.petsop.ui.screens.authScreens.forgotPassScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
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
import com.prueba.petsop.ui.components.buttons.PrimaryButton
import com.prueba.petsop.ui.components.text.AuthOutlinedTextField
import com.prueba.petsop.ui.components.text.LinkedTextRow

@Composable
fun ForgotPasswordScreen(
    onLoginClick: () -> Unit,
    onResetConfirmed: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var emailTouched by remember { mutableStateOf(false) }

    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var newPasswordTouched by remember { mutableStateOf(false) }
    var confirmPasswordTouched by remember { mutableStateOf(false) }

    var showResetFields by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Título
        Text(
            text = "Forgot\nPassword",
            style = MaterialTheme.typography.headlineLarge,
            lineHeight = 40.sp
        )

        Spacer(modifier = Modifier.height(12.dp))

        Text(
            text = "Water is life. Water is a basic human need. In various lines of life, humans need water.",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(32.dp))

        if (!showResetFields) {
            AuthOutlinedTextField(
                value = email,
                onValueChange = { email = it },
                placeholderText = "Email",
                isError = emailTouched && email.isBlank(),
                errorMessage = "Required Fields",
                showErrorMessage = emailTouched
            )
        }

        if (showResetFields) {
            AuthOutlinedTextField(
                value = newPassword,
                onValueChange = { newPassword = it },
                placeholderText = "New Password",
                isError = newPasswordTouched && newPassword.isBlank(),
                errorMessage = "Required Fields",
                showErrorMessage = newPasswordTouched
            )

            Spacer(modifier = Modifier.height(16.dp))

            AuthOutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholderText = "Confirm Password",
                isError = confirmPasswordTouched && confirmPassword.isBlank(),
                errorMessage = "Required Fields",
                showErrorMessage = confirmPasswordTouched
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        // Botón
        PrimaryButton(
            text = if (showResetFields) "Reset Password" else "Next",
            onClick = {
                if (!showResetFields) {
                    emailTouched = true
                    if (email.isNotBlank()) {
                        showResetFields = true
                    }
                } else {
                    newPasswordTouched = true
                    confirmPasswordTouched = true
                    if (newPassword.isNotBlank() && confirmPassword.isNotBlank()) {

                        onResetConfirmed()
                    }
                }
            },
            enabled = if (!showResetFields) {
                email.isNotBlank()
            } else {
                newPassword.isNotBlank() || confirmPassword.isNotBlank()
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        LinkedTextRow(
            normalText = "Have an account?",
            linkText = "Login",
            onLinkClick = onResetConfirmed
        )
    }
}

