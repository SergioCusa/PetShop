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


@Composable
fun ProfileScreen() {
    var isSellerMode by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp), // o 54.dp si querés más ajustado
                contentAlignment = Alignment.Center
            ) {
                ModeSwitchSelector(
                    isSeller = isSellerMode,
                    onToggle = { isSellerMode = it },
                    modifier = Modifier.fillMaxWidth()
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
fun ModeSwitchSelector(
    isSeller: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(300.dp) // Aumenté más el ancho para que quepa con font-size 14
                .height(48.dp)
                .background(Color(0xFFF5F5F5), RoundedCornerShape(24.dp))
                .padding(4.dp)
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Button(
                    onClick = { onToggle(false) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!isSeller) Color(0xFF6C4DF4) else Color.Transparent,
                        contentColor = if (!isSeller) Color.White else Color.Gray
                    ),
                    shape = RoundedCornerShape(20.dp),
                    elevation = if (!isSeller) ButtonDefaults.buttonElevation(2.dp) else ButtonDefaults.buttonElevation(0.dp),
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp)
                ) {
                    Text(
                        "Profile",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium, // Equivalente a font-weight: 500
                        lineHeight = (14 * 1.5).sp // line-height: 150%
                    )
                }

                Button(
                    onClick = { onToggle(true) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isSeller) Color(0xFF6C4DF4) else Color.Transparent,
                        contentColor = if (isSeller) Color.White else Color.Gray
                    ),
                    shape = RoundedCornerShape(20.dp),
                    elevation = if (isSeller) ButtonDefaults.buttonElevation(2.dp) else ButtonDefaults.buttonElevation(0.dp),
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp)
                ) {
                    Text(
                        "Seller Mode",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium, // Equivalente a font-weight: 500
                        lineHeight = (14 * 1.5).sp // line-height: 150%
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileHeader(backgroundImageRes: Int, tintColor: Color, iconRes: Int) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
        Box(
            modifier = Modifier
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
                .offset(y = 109.dp)
                .clip(CircleShape)
                .background(Color.White)
        )
    }
}

@Composable
fun SellerProfileView() {
    ProfileHeader(backgroundImageRes = R.drawable.banner_profile, tintColor = Color(0xFFE1BFA5), iconRes = R.drawable.profile_avatar_pittashop)
    Spacer(modifier = Modifier.height(56.dp))
    Text("Pittashop", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.alignCenter())
    Spacer(modifier = Modifier.height(8.dp))
    SellerStats(followers = 109, following = 992, sales = 80)
    Spacer(modifier = Modifier.height(12.dp))
    CustomTabSelector(listOf("Product", "Sold", "Stats"), "Product")
    Spacer(modifier = Modifier.height(12.dp))
    ProductGrid()
}

@Composable
fun PersonalProfileView() {
    ProfileHeader(backgroundImageRes = R.drawable.banner_profile, tintColor = Color(0xFFD7D9DD), iconRes = R.drawable.profile_avatar_abduldul)
    Spacer(modifier = Modifier.height(56.dp))
    Text("Abduldul", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.alignCenter())
    Spacer(modifier = Modifier.height(8.dp))
    CustomTabSelector(listOf("Saved", "Edit Profile"), "Saved")
    Spacer(modifier = Modifier.height(12.dp))
    ProductGrid()
}

@Composable
fun SellerStats(followers: Int, following: Int, sales: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        StatItem(value = followers, label = "Followers")
        StatItem(value = following, label = "Following")
        StatItem(value = sales, label = "Sales")
    }
}

@Composable
fun StatItem(value: Int, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("$value", fontWeight = FontWeight.Bold)
        Text(label, fontSize = 12.sp)
    }
}

@Composable
fun CustomTabSelector(tabs: List<String>, selected: String) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        tabs.forEach { tab ->
            val selectedColor = if (tab == selected) Color(0xFF6C4DF4) else Color(0xFFEFEFEF)
            val textColor = if (tab == selected) Color.White else Color.Black
            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(selectedColor)
                    .padding(horizontal = 20.dp, vertical = 8.dp)
                    .padding(4.dp)
            ) {
                Text(tab, color = textColor, fontSize = 14.sp)
            }
            Spacer(modifier = Modifier.width(8.dp))
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
