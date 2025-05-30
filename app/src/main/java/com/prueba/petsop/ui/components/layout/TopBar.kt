package com.prueba.petsop.ui.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(
    location: String,
    onSearchClick: () -> Unit,
    onNotificationClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(text = "Location", style = MaterialTheme.typography.labelSmall)
            Text(text = location, style = MaterialTheme.typography.bodyLarge)
        }

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            PlaceholderIcon(onClick = onSearchClick)
            PlaceholderIcon(onClick = onNotificationClick)
        }
    }
}

@Composable
fun PlaceholderIcon(onClick: (() -> Unit)? = null) {
    Box(
        modifier = Modifier
            .size(32.dp)
            .background(Color.Gray, shape = CircleShape)
            .then(
                if (onClick != null) Modifier.clickable { onClick() }
                else Modifier
            )
    )
}
