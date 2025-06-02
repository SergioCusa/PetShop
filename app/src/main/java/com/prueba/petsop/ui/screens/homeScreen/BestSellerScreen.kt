package com.prueba.petsop.ui.screens.homeScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.components.cards.ProductCardSeller
import com.prueba.petsop.ui.components.icons.GetBackIcon
import com.prueba.petsop.ui.components.layout.HomeHeader

@Composable
fun BestSellerScreen(onNavigateToProductDetail: () -> Unit, onBackClick: () -> Unit){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        HomeHeader(
            onBackClick = onBackClick,
            title = "Best Seller"
            )

        Spacer(modifier = Modifier.height(12.dp))

        Row(modifier = Modifier
            .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ){
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(3) {
                    ProductCardSeller(
                        name = "RC Kitten",
                        price = "$20.99",
                        onNavigateToProductDetail = onNavigateToProductDetail,
                        photo = "pink"
                    )
                }
            }
            Spacer(modifier = Modifier.width(15.dp))
            LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                items(3) {
                    ProductCardSeller(
                        name = "RC Persian",
                        price = "$22.99",
                        onNavigateToProductDetail = onNavigateToProductDetail,
                        photo = "yellow"
                    )
                }
            }
        }

    }
}