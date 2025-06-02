package com.prueba.petsop.ui.components.cards

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductCardSeller(
    name: String,
    price: String,
    onNavigateToProductDetail: () -> Unit,
    photo: String) {
    val imageRes = when (photo.lowercase()) {
        "yellow" -> com.prueba.petsop.R.drawable.yellow_product
        "pink" -> com.prueba.petsop.R.drawable.pink_product
        else -> com.prueba.petsop.R.drawable.yellow_product
    }
    Column(
        modifier = Modifier
            .width(173.dp)
            .background(MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(20.dp))
            .padding(12.dp)
            .clickable {
                onNavigateToProductDetail()
        },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier
            .height(150.dp)
            .width(120.dp)){
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(8.dp))
        Row(horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.Bottom){
            Column(){
                Text(text = name, style = MaterialTheme.typography.bodyMedium)
                Text(text = price, style = MaterialTheme.typography.bodyLarge.copy(fontSize = 20.sp, fontWeight = FontWeight.Bold))
            }
            Column(modifier = Modifier
                .padding(start = 45.dp)){
                Box(
                    modifier = Modifier
                        .size(35.dp)
                        .background(MaterialTheme.colorScheme.primary, shape = CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text("+", color = Color.White)
                }
            }

        }

    }
}
