package com.prueba.petsop.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.cards.ProductCardSeller
import com.prueba.petsop.ui.components.icons.FooterItem
import com.prueba.petsop.ui.components.icons.PlaceholderIcon
import com.prueba.petsop.ui.components.items.ProductItem
import com.prueba.petsop.ui.components.layout.BottomNavBar
import com.prueba.petsop.ui.components.layout.ModalBottomSheet
import com.prueba.petsop.ui.components.layout.ModalLocation
import com.prueba.petsop.ui.components.tags.CategoryChipsRow
import com.prueba.petsop.viewmodel.ProductViewModel

@Composable
fun HomeScreen(
    onNavigateToProfile: () -> Unit,
    onNotificationClick: () -> Unit,
    onSearchClick: () -> Unit,
    onNavigateToPurchase: () -> Unit,
    onNavigateToBestSeller: () -> Unit,
    onNavigateToProductDetail: () -> Unit,
    onNavigateToFavorites: () -> Unit,
    viewModel: ProductViewModel = hiltViewModel(),
) {
    val products by viewModel.products.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()
    var showModal by remember { mutableStateOf(false) }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                selectedItem = FooterItem.HOME,
                onNavigateToHome      = {},
                onNavigateToAbout     = {},
                onNavigateToPurchase  = onNavigateToPurchase,
                onNavigateToProfile   = onNavigateToProfile
            )
        }
    ) { innerPadding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(innerPadding),
        ) {
            // ---------- ENCABEZADO Y PROMO ----------
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
            ) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "Location",
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.outline,
                            modifier = Modifier.clickable { showModal = true }
                        )
                        Text(text = "Jebres, Surakarta", style = MaterialTheme.typography.bodyLarge)
                    }

                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        PlaceholderIcon(
                            onClick = onSearchClick,
                            icon = Icons.Default.Search
                        )
                        PlaceholderIcon(
                            onClick = onNotificationClick,
                            icon = Icons.Default.Notifications
                        )
                        PlaceholderIcon(
                            onClick = onNavigateToFavorites,
                            icon = Icons.Filled.Favorite
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.promo_image_2),
                        contentDescription = "Promo",
                        modifier = Modifier.fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                // ---------- CATEGORÍAS ----------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Category", style = MaterialTheme.typography.labelMedium)
                    Text(
                        text = "View All",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 13.sp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))
                CategoryChipsRow()

                Spacer(modifier = Modifier.height(12.dp))
                // ---------- BEST SELLER ----------
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Best Seller", style = MaterialTheme.typography.labelMedium)
                    Text(
                        text = "View All",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 13.sp),
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable { onNavigateToBestSeller() }
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    ProductCardSeller(
                        name = "RC Kitten",
                        price = "$20.99",
                        onNavigateToProductDetail = onNavigateToProductDetail,
                        photo = "pink"
                    )
                    ProductCardSeller(
                        name = "RC Persian",
                        price = "$22.99",
                        onNavigateToProductDetail = onNavigateToProductDetail,
                        photo = "yellow"
                    )
                }

                // ---------- NUEVA LISTA DE PRODUCTOS ----------
                Spacer(modifier = Modifier.height(12.dp))
                Text(text = "Productos", style = MaterialTheme.typography.labelMedium)
                Spacer(modifier = Modifier.height(8.dp))

                products.forEach { product ->
                    ProductItem(
                        product = product,
                        onFavoriteClick = { viewModel.toggleFavorite(product) }
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }

    if (showModal) {
        ModalBottomSheet(
            visible = true,
            onDismiss = { showModal = false }
        ) {
            ModalLocation()
        }
    }
}
