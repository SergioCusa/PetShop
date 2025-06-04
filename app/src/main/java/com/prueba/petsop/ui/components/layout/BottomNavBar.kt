package com.prueba.petsop.ui.components.layout

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prueba.petsop.R
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
                icon = R.drawable.home_icon,
                isSelected = selectedItem == FooterItem.HOME,
                onClick = onNavigateToHome
            )
            FooterIcon(
                icon = R.drawable.chat_icon,
                isSelected = selectedItem == FooterItem.ABOUT,
                onClick = onNavigateToAbout
            )
            FooterIcon(
                icon = R.drawable.bag_icon,
                isSelected = selectedItem == FooterItem.CART,
                onClick = onNavigateToPurchase
            )
            FooterIcon(
                icon = R.drawable.profile_icon,
                isSelected = selectedItem == FooterItem.PROFILE,
                onClick = onNavigateToProfile
            )
        }
    }
}


