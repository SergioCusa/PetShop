package com.prueba.petsop.ui.screens.productListScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.prueba.petsop.viewmodel.ProductViewModel
import com.prueba.petsop.ui.components.items.ProductItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    viewModel: ProductViewModel,
    onNavigateToFavorites: () -> Unit
) {
    val products by viewModel.products.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Productos") },
                actions = {
                    IconButton(onClick = onNavigateToFavorites) {
                        Icon(
                            imageVector = Icons.Filled.Favorite,
                            contentDescription = "Ver favoritos"
                        )
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(horizontal = 16.dp)
        ) {
            items(
                items = products,
                key = { it.id }
            ) { product ->
                ProductItem(
                    product = product,
                    onFavoriteClick = {
                        viewModel.toggleFavorite(product)
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}