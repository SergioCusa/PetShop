package com.prueba.petsop.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prueba.petsop.ui.components.buttons.PrimaryButton
import com.prueba.petsop.ui.components.layout.TopBar
import com.prueba.petsop.ui.components.tags.CategoryChip
import com.prueba.petsop.ui.components.cards.ProductCard
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.prueba.petsop.R


@Composable
fun HomeScreen(
    onNavigateToProfile: () -> Unit,
    onNotificationClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 16.dp)
    ) {
        TopBar(
            location = "Jebres, Surakarta",
            onSearchClick = onSearchClick,
            onNotificationClick = onNotificationClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.promo_image_2),
                contentDescription = "Descripción de la imagen",
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Category", style = MaterialTheme.typography.titleMedium)
            Text(text = "View All", color = MaterialTheme.colorScheme.primary)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            CategoryChip(text = "Food", selected = true)
            CategoryChip(text = "Toys", selected = false)
            CategoryChip(text = "Accessories", selected = false)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Best Seller", style = MaterialTheme.typography.titleMedium)
            Text(text = "View All", color = MaterialTheme.colorScheme.primary)
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            ProductCard(name = "RC Kitten", price = "$20.99")
            ProductCard(name = "RC Persian", price = "$22.99")
        }

        Spacer(modifier = Modifier.height(16.dp))

        PrimaryButton(text = "Go to Profile", onClick = onNavigateToProfile)
    }
}
