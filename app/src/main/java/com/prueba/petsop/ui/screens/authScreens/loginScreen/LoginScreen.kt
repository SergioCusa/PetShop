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
import com.prueba.petsop.ui.components.buttons.SaveButton
import com.prueba.petsop.ui.components.text.ValidateTextField
import com.prueba.petsop.ui.components.text.LinkedTextRow

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val allValid = email.isNotBlank() && password.isNotBlank()

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
            onValueChange = { email = it },
            placeholder = "Email",
            showError =  email.isEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

        ValidateTextField(
            value = password,
            onValueChange = { password = it },
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

        Spacer(modifier = Modifier.height(200.dp))

        LinkedTextRow(
            normalText = "Don’t have an account?",
            linkText = "Create Account",
            onLinkClick = onRegisterClick
        )

        Spacer(modifier = Modifier.height(32.dp))

        LinkedTextRow(
            normalText = "",
            linkText = "Forgot your password?",
            onLinkClick = onForgotClick
        )

        Spacer(modifier = Modifier.height(32.dp))

        PrimaryButton(text = "Get Started", enabled = allValid, onClick = onLoginClick)


    }
}


