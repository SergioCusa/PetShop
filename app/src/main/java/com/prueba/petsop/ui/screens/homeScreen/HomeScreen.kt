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
import com.prueba.petsop.ui.components.layout.BottomNavBar
import com.prueba.petsop.ui.components.cards.ProductCard
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.icons.FooterItem
import com.prueba.petsop.ui.components.layout.ModalBottomSheet
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.prueba.petsop.ui.components.layout.ModalLocation
import com.prueba.petsop.ui.components.icons.PlaceholderIcon


@Composable
fun HomeScreen(
    onNavigateToProfile: () -> Unit,
    onNotificationClick: () -> Unit,
    onSearchClick: () -> Unit,
    onNavigateToPurchase: () -> Unit
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
//            TopBar(
//                location = "Jebres, Surakarta",
//                onSearchClick = onSearchClick,
//                onNotificationClick = onNotificationClick
//            )
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

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Category", style = MaterialTheme.typography.labelMedium)
                    Text(
                        text = "View All",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.shufle_icon),
                        contentDescription = "Shuffle",
                        modifier = Modifier
                            .height(60.dp)
                            .width(60.dp)
                    )
                    CategoryChip(text = "Food", selected = true)
                    CategoryChip(text = "Toys", selected = false)
                    CategoryChip(text = "Accessories", selected = false)
                }

                Spacer(modifier = Modifier.height(24.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Best Seller", style = MaterialTheme.typography.labelMedium)
                    Text(
                        text = "View All",
                        style = MaterialTheme.typography.labelSmall.copy(fontSize = 12.sp),
                        color = MaterialTheme.colorScheme.primary
                    )
                }

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ProductCard(name = "RC Kitten", price = "$20.99")
                    ProductCard(name = "RC Persian", price = "$22.99")
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
