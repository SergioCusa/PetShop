package com.prueba.petsop.ui.screens.productDetailsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductDetailsScreen(
    productId: String?
) {
    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text(
            text = "Product Details",
            style = MaterialTheme.typography.headlineMedium
        )
        Text(
            text = "Product ID: $productId",
            style = MaterialTheme.typography.bodyMedium
        )
    }
}