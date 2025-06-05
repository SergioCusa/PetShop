package com.prueba.petsop.ui.screens.paymentMethodScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.buttons.SaveButton
import com.prueba.petsop.ui.components.layout.HomeHeader
import com.prueba.petsop.ui.components.text.ValidateTextField


@Composable
fun PaymentMethodScreen(
    onBackClick: () -> Unit,
    onCheckoutClick: () -> Unit
) {
    var cardNumber by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var expiration by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    val allValid =
        cardNumber.isNotBlank() &&
                name.isNotBlank() &&
                expiration.isNotBlank() &&
                cvv.isNotBlank()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        HomeHeader(
            onBackClick = onBackClick,
            title = stringResource(id = R.string.payment_method)
        )

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {

            Text(
                text = stringResource(id = R.string.add_payment),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            ValidateTextField(
                value = cardNumber,
                onValueChange = { cardNumber = it },
                placeholder = stringResource(id = R.string.card_number),
                showError = cardNumber.isEmpty()
            )
            Spacer(modifier = Modifier.height(16.dp))
            ValidateTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = stringResource(id = R.string.card_name),
                showError = name.isEmpty()
            )
            Spacer(modifier = Modifier.height(16.dp))
            ValidateTextField(
                value = expiration,
                onValueChange = { expiration = it },
                placeholder = stringResource(id = R.string.expire),
                showError = expiration.isEmpty()
            )
            Spacer(modifier = Modifier.height(16.dp))
            ValidateTextField(
                value = cvv,
                onValueChange = { cvv = it },
                placeholder = stringResource(id = R.string.cvv),
                showError = cvv.isEmpty()
            )

            Spacer(modifier = Modifier.weight(1f))

            SaveButton(
                text = stringResource(id = R.string.save),
                enabled = allValid,
                onClick = onCheckoutClick
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

