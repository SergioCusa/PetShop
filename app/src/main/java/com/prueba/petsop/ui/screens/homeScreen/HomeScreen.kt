package com.prueba.petsop.ui.screens.homeScreen

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
            location = "Buenos Aires",
            onSearchClick = onSearchClick,
            onNotificationClick = onNotificationClick
        )

        Spacer(modifier = Modifier.height(16.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .padding(8.dp)
        ) {
            Text("Promo Placeholder")
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
