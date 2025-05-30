package com.prueba.petsop.ui.screens.paymentMethodScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.prueba.petsop.ui.components.buttons.PrimaryButton

@Composable
fun PaymentMethodScreen() {
    var cardNumber by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var expiry by remember { mutableStateOf("") }
    var cvv by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(24.dp)) {
        Text("Add New Payment")
        Spacer(modifier = Modifier.height(16.dp))
        OutlinedTextField(
            value = cardNumber,
            onValueChange = { cardNumber = it },
            placeholder = { Text("Card Number") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = name, onValueChange = { name = it }, placeholder = { Text("Card Name") })
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = expiry, onValueChange = { expiry = it }, placeholder = { Text("Expired") })
        Spacer(modifier = Modifier.height(12.dp))
        OutlinedTextField(value = cvv, onValueChange = { cvv = it }, placeholder = { Text("CVV") })
        Spacer(modifier = Modifier.height(24.dp))
        PrimaryButton(text = "Save", onClick = {})
    }
}
