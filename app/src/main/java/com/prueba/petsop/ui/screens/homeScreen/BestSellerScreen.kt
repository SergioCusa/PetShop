package com.prueba.petsop.ui.screens.homeScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.prueba.petsop.ui.components.cards.ProductCard
import com.prueba.petsop.ui.components.cards.ProductCardYellow

@Composable
fun BestSellerScreen(onNavigateToProductDetail: () -> Unit){

    Column(){
        Text("Best Seller Screen")
        ProductCardYellow(
            name = "RC Persian",
            price = "$22.99",
            onNavigateToProductDetail = onNavigateToProductDetail)
    }
}