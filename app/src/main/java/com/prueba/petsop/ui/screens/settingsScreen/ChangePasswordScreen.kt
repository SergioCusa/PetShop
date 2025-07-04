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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.buttons.SaveButton
import com.prueba.petsop.ui.components.layout.HomeHeader
import com.prueba.petsop.ui.components.text.ValidateTextField

@Composable
fun ChangePasswordScreen(
    onBackClick: () -> Unit,
    onNavigateToSettings:  () -> Unit
) {
    var newPassword by remember { mutableStateOf("") }
    var ConfirmPassword by remember { mutableStateOf("") }

    val allValid =
        (newPassword.isNotBlank() && ConfirmPassword.isNotBlank()) && newPassword == ConfirmPassword

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        HomeHeader(
            onBackClick = onBackClick,
            title = stringResource(R.string.change_password)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {

            Text(
                text = stringResource(R.string.new_password),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 12.dp, top = 16.dp)
            )

            ValidateTextField(
                value = newPassword,
                onValueChange = { newPassword = it },
                placeholder = "",
                showError = newPassword.isEmpty(),
                isPassword = true
            )

            Text(
                text = stringResource(R.string.confirm_password),
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 12.dp, top = 16.dp)
            )

            ValidateTextField(
                value = ConfirmPassword,
                onValueChange = { ConfirmPassword = it },
                placeholder = "",
                showError = ConfirmPassword.isEmpty(),
                isPassword = true
            )

            Spacer(modifier = Modifier.weight(1f))

            SaveButton(
                text = stringResource(R.string.change_password),
                enabled = allValid,
                onClick = onNavigateToSettings
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}