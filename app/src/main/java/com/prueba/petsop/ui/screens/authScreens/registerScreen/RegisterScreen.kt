package com.prueba.petsop.ui.screens.authScreens.registerScreen


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
import com.prueba.petsop.ui.components.text.LinkedTextRow
import com.prueba.petsop.ui.components.text.ValidateTextField

@Composable
fun RegisterScreen(
    onHaveAcountClick: () -> Unit,
    onLoginClick: () -> Unit,

) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var fullName by remember { mutableStateOf("") }

    val allValid = email.isNotBlank() && password.isNotBlank() && fullName.isNotBlank()

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
                text = "Create New\nAccount",
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
        ValidateTextField(
            value = fullName,
            onValueChange = { fullName = it },
            placeholder = "fullName",
            showError =  fullName.isEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

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
            placeholder = "password",
            showError =  password.isEmpty()
        )

        Spacer(modifier = Modifier.height(50.dp))


        Spacer(modifier = Modifier.height(200.dp))
        // Texto con link
        LinkedTextRow(
            normalText = "have an account?",
            linkText = "Login",
            onLinkClick = { onHaveAcountClick() }
        )


        Spacer(modifier = Modifier.height(32.dp))

        PrimaryButton(text = "Get Started", enabled = allValid, onClick = onHaveAcountClick)

    }
}
