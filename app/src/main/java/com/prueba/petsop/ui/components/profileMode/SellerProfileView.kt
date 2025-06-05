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
import com.prueba.petsop.ui.components.profileMode.stats.SellerStats
import com.prueba.petsop.ui.screens.profileScreen.alignCenter

@Composable
fun SellerProfileView(
    onNavigateToProductDetail: () -> Unit
) {
    var selectedTab by remember { mutableStateOf("Product") }
    ProfileBanner(R.drawable.banner_profile, Color(0xFFFD9340), R.drawable.profile_avatar_pittashop, "Pittashop")
    SellerStats(followers = 109, following = 992, sales = 80)
    Spacer(modifier = Modifier.height(8.dp))
    CategoryChipRow(listOf("Product", "Sold", "Stats"), selectedTab, { selectedTab = it }, Modifier.alignCenter())
    Spacer(modifier = Modifier.height(12.dp))
    ProductGrid(onNavigateToProductDetail)
}