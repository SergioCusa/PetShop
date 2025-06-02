package com.prueba.petsop.ui.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prueba.petsop.ui.components.icons.FooterIcon
import com.prueba.petsop.ui.components.icons.FooterItem

@Composable
fun BottomNavBar(
    selectedItem: FooterItem,
    onNavigateToHome: () -> Unit,
    onNavigateToAbout: () -> Unit,
    onNavigateToPurchase: () -> Unit,
    onNavigateToProfile: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant,
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp)
            )
            ,
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            FooterIcon(
                icon = Icons.Default.Home,
                isSelected = selectedItem == FooterItem.HOME,
                onClick = onNavigateToHome
            )
            FooterIcon(
                icon = Icons.Default.Info,
                isSelected = selectedItem == FooterItem.ABOUT,
                onClick = onNavigateToAbout
            )
            FooterIcon(
                icon = Icons.Default.ShoppingCart,
                isSelected = selectedItem == FooterItem.CART,
                onClick = onNavigateToPurchase
            )
            FooterIcon(
                icon = Icons.Default.Person,
                isSelected = selectedItem == FooterItem.PROFILE,
                onClick = onNavigateToProfile
            )
        }
    }
}


