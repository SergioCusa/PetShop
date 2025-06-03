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
import com.prueba.petsop.ui.components.text.ValidateTextField

@Composable
fun ForgotPasswordScreen(
    onLoginClick: () -> Unit,
    onResetConfirmed: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var newPassword by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    var showResetFields by remember { mutableStateOf(false) }

    val firstStepValid = email.isNotBlank()
    val secondStepValid = newPassword.isNotBlank() && confirmPassword.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 36.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
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
            ValidateTextField(
                value = email,
                onValueChange = { email = it },
                placeholder = "Email",
                showError = !firstStepValid
            )
        } else {
            ValidateTextField(
                value = newPassword,
                onValueChange = { newPassword = it },
                placeholder = "New Password",
                showError = newPassword.isEmpty()
            )

            Spacer(modifier = Modifier.height(16.dp))

            ValidateTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                placeholder = "Confirm Password",
                showError = confirmPassword.isEmpty()
            )
        }

        Spacer(modifier = Modifier.height(32.dp))

        PrimaryButton(
            text = if (showResetFields) "Reset Password" else "Next",
            onClick = {
                if (!showResetFields && firstStepValid) {
                    showResetFields = true
                } else if (showResetFields && secondStepValid) {
                    onResetConfirmed()
                }
            },
            enabled = if (!showResetFields) firstStepValid else secondStepValid
        )

        Spacer(modifier = Modifier.height(24.dp))

        LinkedTextRow(
            normalText = "Have an account?",
            linkText = "Login",
            onLinkClick = onLoginClick
        )
    }
}

