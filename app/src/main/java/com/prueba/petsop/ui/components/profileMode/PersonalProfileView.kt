package com.prueba.petsop.ui.components.profileMode

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.banners.ProfileBanner
import com.prueba.petsop.ui.components.cards.ProductGrid
import com.prueba.petsop.ui.components.profileMode.stats.CategoryChipRow
import com.prueba.petsop.ui.screens.profileScreen.alignCenter

@Composable
fun PersonalProfileView(
    onNavigateToProductDetail: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    var selectedTab by remember { mutableStateOf("Saved") }
    ProfileBanner(backgroundImageRes = R.drawable.banner_profile, tintColor = Color(0xFFF8F8F8), iconRes = R.drawable.profile_avatar_abduldul, "Abduldul")
    CategoryChipRow(
        listOf("Saved", "Edit Profile"),
        selected = selectedTab,
        onSelectedChange = { newTab ->
            selectedTab = newTab
            if (newTab == "Edit Profile") {
                onNavigateToSettings()
            }
        },
        modifier = Modifier.alignCenter()
    )
    Spacer(modifier = Modifier.height(12.dp))
    ProductGrid(onNavigateToProductDetail)
}
