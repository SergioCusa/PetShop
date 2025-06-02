package com.prueba.petsop.ui.screens.notificationScreen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prueba.petsop.ui.components.buttons.NotificationTabSelector
import com.prueba.petsop.ui.components.cards.NotificationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.cards.NotificationItemSeller
import com.prueba.petsop.ui.components.icons.GetBackIcon
import com.prueba.petsop.ui.components.icons.PlaceholderIcon

@Composable
fun NotificationScreen(
    onBackClick: () -> Unit
) {
    var selectedTab by remember { mutableStateOf("Activity") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            GetBackIcon(onClick = onBackClick)
            Spacer(modifier = Modifier.width(50.dp))
            Text(
                text = "Notification",
                style = MaterialTheme.typography.titleMedium.copy(fontSize = 17.sp, fontWeight = FontWeight.Bold),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        NotificationTabSelector(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Contenido según pestaña seleccionada
        when (selectedTab) {
            "Activity" -> {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                    items(4) {
                        NotificationItem(
                            imageRes = null,
                            title = "SALE 50%",
                            subtitle = "Check the details!"
                        )
                    }
                }
//                Column(verticalArrangement = Arrangement.spacedBy(16.dp)){
//                    NotificationItem(
//                        imageRes = null,
//                        title = "SALE 50%",
//                        subtitle = "Check the details!"
//                    )
//                }
            }
            "Seller Mode" -> {
                Column(verticalArrangement = Arrangement.spacedBy(18.dp)){
                    NotificationItem(
                        imageRes = null,
                        title = "SALE 50%",
                        subtitle = "Check the details!"
                    )
                    NotificationItemSeller(
                        imageRes = null,
                        title = "Momon",
                        subtitle = "Liked your Product",
                        idSeller = R.drawable.seller_momon
                    )
                    NotificationItemSeller(
                        imageRes = null,
                        title = "Ola",
                        subtitle = "Liked your Product",
                        idSeller = R.drawable.seller_ola
                    )
                    NotificationItemSeller(
                        imageRes = null,
                        title = "Raul",
                        subtitle = "Liked your Product",
                        idSeller = R.drawable.seller_raul
                    )
                }
                Spacer(modifier = Modifier.height(18.dp))
                LazyColumn(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                    items(3) {
                        NotificationItem(
                            imageRes = null,
                            title = "You Got New Order!",
                            subtitle = "Please arrange delivery"
                        )
                    }
                }
                Spacer(modifier = Modifier.height(18.dp))
                NotificationItemSeller(
                    imageRes = null,
                    title = "Vito",
                    subtitle = "Liked your Product",
                    idSeller = R.drawable.seller_vito
                )
            }
        }
    }
}

