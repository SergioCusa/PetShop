package com.prueba.petsop.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun NotificationTabSelector(selectedTab: String, onTabSelected: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFFF5F5F5), shape = MaterialTheme.shapes.large)
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        listOf("Activity", "Seller Mode").forEach { tab ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .clickable { onTabSelected(tab) }
                    .background(
                        color = if (selectedTab == tab) MaterialTheme.colorScheme.primary else Color.Transparent,
                        shape = MaterialTheme.shapes.medium
                    )
                    .padding(vertical = 10.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = tab,
                    color = if (selectedTab == tab) Color.White else Color.Gray
                )
            }
        }
    }
}
