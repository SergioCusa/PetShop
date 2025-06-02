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
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

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
        // Top bar con ícono de volver y título
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            IconButton(onClick = onBackClick) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowLeft,
                    contentDescription = "Back"
                )
            }
            Text(
                text = "Notification",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 93.dp)
            )

        }

        Spacer(modifier = Modifier.height(16.dp))

        // Selector de pestañas
        NotificationTabSelector(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Contenido según pestaña seleccionada
        when (selectedTab) {
            "Activity" -> {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(4) {
                        NotificationItem(
                            imageRes = null,
                            title = "SALE 50%",
                            subtitle = "Check the details!"
                        )
                    }
                }
            }
            "Updates" -> {
                LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
                    items(3) {
                        NotificationItem(
                            imageRes = null,
                            title = "App Update",
                            subtitle = "Version 2.0 is now available!"
                        )
                    }
                }
            }
        }
    }
}

