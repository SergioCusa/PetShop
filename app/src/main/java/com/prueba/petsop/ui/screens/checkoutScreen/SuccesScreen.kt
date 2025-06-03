package com.prueba.petsop.ui.screens.checkoutScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.components.buttons.SaveButton
import com.prueba.petsop.ui.components.layout.HomeHeader

@Composable
fun SuccesScreen(
    onNavigateToHome: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = "Payment Success!",
            style = MaterialTheme.typography.labelMedium.copy(fontSize = 40.sp),
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "your order is being prepared by the shop, the courier will send it to your address",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline

        )

        Spacer(modifier = Modifier.weight(1f))
        SaveButton(text = "Go Home", enabled = true, onClick = onNavigateToHome)
        Spacer(modifier = Modifier.height(16.dp))
    }
}