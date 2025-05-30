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

@Composable
fun NotificationScreen() {
    var selectedTab by remember { mutableStateOf("Activity") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Notification",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        NotificationTabSelector(
            selectedTab = selectedTab,
            onTabSelected = { selectedTab = it }
        )

        Spacer(modifier = Modifier.height(24.dp))

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
}
