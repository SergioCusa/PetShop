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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.components.buttons.SaveButton
import com.prueba.petsop.ui.components.icons.GetBackIcon
import com.prueba.petsop.ui.components.layout.HomeHeader
import com.prueba.petsop.ui.components.text.PaymentTextField


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
            title = "Payment Method"
        )

        Column(modifier = Modifier
            .padding(horizontal = 20.dp)
        ) {

            Text(
                text = "Add New Payment",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            PaymentTextField(
                value = cardNumber,
                onValueChange = { cardNumber = it },
                placeholder = "Card number",
                showError = cardNumber.isEmpty()
            )
            Spacer(modifier = Modifier.height(16.dp))
            PaymentTextField(
                value = name,
                onValueChange = { name = it },
                placeholder = "Card Name",
                showError = name.isEmpty()
            )
            Spacer(modifier = Modifier.height(16.dp))
            PaymentTextField(
                value = expiration,
                onValueChange = { expiration = it },
                placeholder = "Expire",
                showError = expiration.isEmpty()
            )
            Spacer(modifier = Modifier.height(16.dp))
            PaymentTextField(
                value = cvv,
                onValueChange = { cvv = it },
                placeholder = "CVV",
                showError = cvv.isEmpty()
            )

            Spacer(modifier = Modifier.weight(1f))

            SaveButton(text = "Save", enabled = allValid, onClick = onCheckoutClick)

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

