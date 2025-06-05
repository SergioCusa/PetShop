package com.prueba.petsop.ui.screens.profileScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.banners.ProfileBanner
import com.prueba.petsop.ui.components.buttons.ModeSwitchSelector
import com.prueba.petsop.ui.components.cards.ProductCardSeller
import com.prueba.petsop.ui.components.icons.FooterItem
import com.prueba.petsop.ui.components.layout.BottomNavBar
import com.prueba.petsop.ui.components.tags.CategoryChip


@Composable
fun ProfileScreen(
    onNavigateToProductDetail: () -> Unit,
    onNavigateToHome: () -> Unit,
    onNavigateToPurchase: () -> Unit,
    onNavigateToSettings: () -> Unit
) {
    var isSellerMode by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(100.dp)
                    .statusBarsPadding(),
                contentAlignment = Alignment.Center
            ) {
                ModeSwitchSelector(
                    leftText = "Profile",
                    rightText = "Seller Mode",
                    isRightSelected = isSellerMode,
                    onToggle = { isSellerMode = it }
                )
            }
        },
        bottomBar = {
            if (!isSellerMode) {
                BottomNavBar(
                    selectedItem = FooterItem.PROFILE,
                    onNavigateToHome = onNavigateToHome,
                    onNavigateToAbout = {},
                    onNavigateToPurchase = onNavigateToPurchase,
                    onNavigateToProfile = {}
                )
            }
        },
        containerColor = Color.White,
        contentWindowInsets = WindowInsets(0)
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (isSellerMode) {
                SellerProfileView(onNavigateToProductDetail)
            } else {
                PersonalProfileView(
                    onNavigateToProductDetail = onNavigateToProductDetail,
                    onNavigateToSettings = onNavigateToSettings)
            }
        }
    }
}

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

@Composable
fun SellerStats(followers: Int, following: Int, sales: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            StatItem(value = followers, label = "Followers")
            StatItem(value = following, label = "Following")
            StatItem(value = sales, label = "Sales")
        }
    }
}

@Composable
fun StatItem(value: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "$value",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.Gray
        )
    }
}

@Composable
fun CategoryChipRow(
    options: List<String>,
    selected: String,
    onSelectedChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(top = 24.dp)
    ) {
        options.forEach { option ->
            CategoryChip(
                text = option,
                selected = option == selected,
                onClick = { onSelectedChange(option) }
            )
        }
    }
}

@Composable
fun ProductGrid(
    onNavigateToProductDetail: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .padding(top = 32.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProductCardSeller(name = "RC Kitten", price = "$20.99", onNavigateToProductDetail = onNavigateToProductDetail, photo = "pink")
        ProductCardSeller(name = "RC Persian", price = "$22.99", onNavigateToProductDetail = onNavigateToProductDetail, photo = "yellow")
    }
}

@Composable
fun Modifier.alignCenter(): Modifier = this.then(
    Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
)
