package com.prueba.petsop.ui.screens.checkoutScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.components.buttons.SaveButton
import com.prueba.petsop.ui.components.icons.GetBackIcon
import com.prueba.petsop.ui.components.layout.HomeHeader
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.prueba.petsop.ui.components.buttons.SelectablePayment

@Composable
fun CheckoutScreen(
    onBackClick: () -> Unit,
    onSuccesClick: () -> Unit
){
    var isValid by remember { mutableStateOf(false) }
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
            .padding(horizontal = 20.dp)){
            Text(
                text = "Choose your Payment Method",
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            SelectablePayment(onSelectionChanged = {
                isValid = it},
                opt1 = "Paypal",
                opt2 = "Bank Transfer"
            )

            Spacer(modifier = Modifier.weight(1f))

            SaveButton(text = "Checkout", enabled = isValid, onClick = onSuccesClick)

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}