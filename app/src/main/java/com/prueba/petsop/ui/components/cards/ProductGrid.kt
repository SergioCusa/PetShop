package com.prueba.petsop.ui.components.cards

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProductGrid(
    onNavigateToProductDetail: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 28.dp)
            .padding(top = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProductCardSeller(name = "RC Kitten", price = "$20.99", onNavigateToProductDetail = onNavigateToProductDetail, photo = "pink")
        ProductCardSeller(name = "RC Persian", price = "$22.99", onNavigateToProductDetail = onNavigateToProductDetail, photo = "yellow")
    }
}