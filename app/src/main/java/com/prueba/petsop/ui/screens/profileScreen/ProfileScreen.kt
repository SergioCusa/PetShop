package com.prueba.petsop.ui.screens.profileScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.cards.ProductCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import com.prueba.petsop.ui.components.buttons.ModeSwitchSelector
import com.prueba.petsop.ui.components.tags.CategoryChip


@Composable
fun ProfileScreen() {
    var isSellerMode by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
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
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            if (isSellerMode) {
                SellerProfileView()
            } else {
                PersonalProfileView()
            }
        }
    }
}

@Composable
fun ProfileHeader(backgroundImageRes: Int, tintColor: Color, iconRes: Int) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
        Box(
            modifier = Modifier
                .padding(top = 16.5.dp)
                .width(327.dp)
                .height(159.dp)
                .clip(RoundedCornerShape(24.dp))
        ) {
            Image(
                painter = painterResource(id = backgroundImageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(tintColor, BlendMode.Multiply),
                modifier = Modifier.fillMaxSize()
            )
        }
        Image(
            painter = painterResource(id = iconRes),
            contentDescription = null,
            modifier = Modifier
                .size(100.dp)
                .offset(y = 125.5.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
    }
}

@Composable
fun SellerProfileView() {
    var selectedTab by remember { mutableStateOf("Product") }
    ProfileHeader(backgroundImageRes = R.drawable.banner_profile, tintColor = Color(0xFFFD9340), iconRes = R.drawable.profile_avatar_pittashop)
    Text("Pittashop", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.alignCenter().padding(top = 74.dp))
    SellerStats(followers = 109, following = 992, sales = 80)
    Spacer(modifier = Modifier.height(50.dp))
    CategoryChip(text = "Food", selected = true)
    Spacer(modifier = Modifier.height(12.dp))
    ProductGrid()
}

@Composable
fun PersonalProfileView() {
    var selectedTab by remember { mutableStateOf("Saved") }
    ProfileHeader(backgroundImageRes = R.drawable.banner_profile, tintColor = Color(0xFFF8F8F8), iconRes = R.drawable.profile_avatar_abduldul)
    Text("Abduldul", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.alignCenter().padding(top = 74.dp))
    Spacer(modifier = Modifier.height(8.dp))
    CategoryChipRow(listOf("Saved", "Edit Profile"), selected = selectedTab,onSelectedChange = { selectedTab = it }, modifier = Modifier.alignCenter())
    Spacer(modifier = Modifier.height(12.dp))
    ProductGrid()
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
            fontSize = 16.sp // Agregado para mejor visibilidad
        )
        Text(
            text = label,
            fontSize = 12.sp,
            color = Color.Gray // Agregado para diferenciarlo del número
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
fun ProductGrid() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ProductCard(name = "RC Kitten", price = "$20,99")
        ProductCard(name = "RC Persian", price = "$22,99")
    }
}

@Composable
fun Modifier.alignCenter(): Modifier = this.then(
    Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
)
