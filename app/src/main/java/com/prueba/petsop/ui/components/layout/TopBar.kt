package com.prueba.petsop.ui.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.components.icons.PlaceholderIcon

@Composable
fun TopBar(
    location: String,
    onSearchClick: () -> Unit,
    onNotificationClick: () -> Unit
) {
    var showModal by remember { mutableStateOf(false) }

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
            Text(text = location, style = MaterialTheme.typography.bodyLarge)
        }

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            PlaceholderIcon(onClick = onSearchClick,
                icon = Icons.Default.Search)
            PlaceholderIcon(onClick = onNotificationClick,
                icon = Icons.Default.Notifications,)
        }
    }
}
//
//@Composable
//fun PlaceholderIcon(
//    onClick: (() -> Unit)? = null,
//    icon: ImageVector) {
//    Box(
//        modifier = Modifier
//            .size(46.dp)
//            .shadow(8.dp, shape = RoundedCornerShape(12.dp))
//            .background(MaterialTheme.colorScheme.background, RoundedCornerShape(10.dp))
//            .then(
//                if (onClick != null) Modifier.clickable { onClick() }
//                else Modifier
//            ),
//        contentAlignment = Alignment.Center
//    ){
//        Icon(
//            imageVector = icon,
//            contentDescription = null,
//            tint = MaterialTheme.colorScheme.onBackground,
//            modifier = Modifier.size(28.dp)
//        )
//    }
//}