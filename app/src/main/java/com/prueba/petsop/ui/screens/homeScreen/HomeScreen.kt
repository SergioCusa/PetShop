package com.prueba.petsop.ui.screens.homeScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.cards.ProductCardSeller
import com.prueba.petsop.ui.components.icons.FooterItem
import com.prueba.petsop.ui.components.icons.PlaceholderIcon
import com.prueba.petsop.ui.components.layout.BottomNavBar
import com.prueba.petsop.ui.components.layout.ModalBottomSheet
import com.prueba.petsop.ui.components.layout.ModalLocation
import com.prueba.petsop.ui.components.tags.CategoryChipsRow


@Composable
fun HomeScreen(
    onNavigateToProfile: () -> Unit,
    onNotificationClick: () -> Unit,
    onSearchClick: () -> Unit,
    onNavigateToPurchase: () -> Unit,
    onNavigateToBestSeller: () -> Unit,
    onNavigateToProductDetail: () -> Unit
) {
    var showModal by remember { mutableStateOf(false) }

        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Bottom
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 24.dp)
            ) {
                Spacer(modifier = Modifier.height(24.dp))
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
                            icon = Icons.Default.Notifications,
                        )
                    }
                }

                Spacer(modifier = Modifier.height(5.dp))

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.promo_image_2),
                        contentDescription = "Promo",
                        modifier = Modifier
                            .fillMaxSize()
                    )
                }

                Spacer(modifier = Modifier.height(35.dp))

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

                Spacer(modifier = Modifier.height(20.dp))

                CategoryChipsRow()

                Spacer(modifier = Modifier.height(50.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Best Seller", style = MaterialTheme.typography.labelMedium)
                    Text(
                        text = "View All",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 13.sp),
                        color = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.clickable {
                            onNavigateToBestSeller()
                        },
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    ProductCardSeller(name = "RC Kitten", price = "$20.99", onNavigateToProductDetail = onNavigateToProductDetail, photo = "pink")
                    ProductCardSeller(name = "RC Persian", price = "$22.99", onNavigateToProductDetail = onNavigateToProductDetail, photo = "yellow")
                }
            }
            Spacer(modifier = Modifier.weight(1f))

            BottomNavBar(
                selectedItem = FooterItem.HOME,
                onNavigateToHome = {},
                onNavigateToAbout = {},
                onNavigateToPurchase = onNavigateToPurchase,
                onNavigateToProfile = onNavigateToProfile
            )

        }
    Box(
    ){
        ModalBottomSheet(
            visible = showModal,
            onDismiss = { showModal = false }
        ) {
            Column() {
                ModalLocation()
            }
        }
    }

}
