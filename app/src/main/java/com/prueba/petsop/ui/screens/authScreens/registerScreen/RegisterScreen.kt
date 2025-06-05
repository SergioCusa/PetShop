package com.prueba.petsop.ui.screens.authScreens.registerScreen


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.buttons.PrimaryButton
import com.prueba.petsop.ui.components.screnHeader.ScreenHeader
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
        ScreenHeader(
            title = stringResource(id = R.string.createAcount_title),
            subtitle = stringResource(id = R.string.subtitle)
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Inputs
        ValidateTextField(
            value = fullName,
            onValueChange = { fullName = it },
            placeholder = stringResource(id = R.string.full_name),
            showError =  fullName.isEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

        ValidateTextField(
            value = email,
            onValueChange = { email = it },
            placeholder = stringResource(id = R.string.email),
            showError =  email.isEmpty()
        )

        Spacer(modifier = Modifier.height(16.dp))

        ValidateTextField(
            value = password,
            onValueChange = { password = it },
            placeholder = stringResource(id = R.string.password),
            showError =  password.isEmpty(),
            isPassword = true
        )

        Spacer(modifier = Modifier.height(50.dp))

        Spacer(modifier = Modifier.height(200.dp))

        // Texto con link
        LinkedTextRow(
            normalText = stringResource(id = R.string.have_account),
            linkText = stringResource(id = R.string.login),
            onLinkClick = { onHaveAcountClick() }
        )

        Spacer(modifier = Modifier.height(32.dp))

        PrimaryButton(
            text = stringResource(id = R.string.get_started),
            enabled = allValid,
            onClick = onHaveAcountClick
        )
    }
}
