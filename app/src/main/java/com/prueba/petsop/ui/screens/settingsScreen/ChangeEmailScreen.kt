package com.prueba.petsop.ui.screens.settingsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.components.buttons.SaveButton
import com.prueba.petsop.ui.components.layout.HomeHeader
import com.prueba.petsop.ui.components.text.ValidateTextField

@Composable
fun ChangeEmailScreen(
    onBackClick: () -> Unit,
    onNavigateToSettings:  () -> Unit
) {
    var newEmail by remember { mutableStateOf("") }

    val allValid = newEmail.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        HomeHeader(
            onBackClick = onBackClick,
            title = "Change Email"
        )

        Column(

            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {

            Text(
                text = "New Password",
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 12.dp, top = 16.dp)
            )

            ValidateTextField(
                value = newEmail,
                onValueChange = { newEmail = it },
                placeholder = "",
                showError = newEmail.isEmpty()
            )

            Spacer(modifier = Modifier.weight(1f))

            SaveButton(text = "Change Email", enabled = allValid, onClick = onNavigateToSettings)

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}