package com.prueba.petsop.ui.screens.authScreens.loginScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.components.buttons.PrimaryButton
import com.prueba.petsop.ui.components.text.SubtitleText
import com.prueba.petsop.ui.components.text.TitleText

@Composable
fun LoginScreen(
    onLoginClick: () -> Unit,
    onRegisterClick: () -> Unit,
    onForgotClick: () -> Unit
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.Start) {
            TitleText(text = "Hello,\nWelcome Back!")
            Spacer(modifier = Modifier.height(12.dp))
            SubtitleText(text = "Water is life. Water is a basic human need. In various lines of life, humans need water.")
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Email") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                placeholder = { Text("Password") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(24.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                IconButton(onClick = { /* Handle Google login */ }) {
                    Icon(imageVector = Icons.Default.MailOutline, contentDescription = "Google")
                }
                IconButton(onClick = { /* Handle Facebook login */ }) {
                    Box(
                        modifier = Modifier
                            .size(24.dp)
                            .background(Color.Gray),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("F", color = Color.White, fontSize = 12.sp)
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(text = "Get Started", onClick = onLoginClick)
        }

        TextButton(onClick = onRegisterClick) {
            Text("Don’t have an account? Create Account")
        }
    }
}
