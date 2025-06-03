package com.prueba.petsop.ui.screens.settingsScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.layout.HomeHeader


@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onNavigateToAccount: () -> Unit,
    onNavigateToAddress: () -> Unit,
    onNavigateToNotification: () -> Unit,
    onNavigateToPaymentMethod: () -> Unit,
    onNavigateToPrivacy: () -> Unit,
    onNavigateToSecurity: () -> Unit,
    onNavigateToContact: () -> Unit,
    onNavigateToFAQ: () -> Unit
) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .statusBarsPadding()
                    .height(90.dp)
                    .padding(horizontal = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                HomeHeader(
                    onBackClick = onBackClick,
                    title = "Settings Page"
                )
            }
        },
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 24.dp)
        ) {
            Spacer(modifier = Modifier.height(5.dp))

            Text(text = "Account", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier.padding(bottom = 16.dp))

            SettingsItem(icon = R.drawable.profile_icon, title = "Account", onClick = onNavigateToAccount)
            SettingsItem(icon = R.drawable.home_icon, title = "Address", onClick = {})
            SettingsItem(icon = R.drawable.notification_icon, title = "Notification", onClick = {})
            SettingsItem(icon = R.drawable.wallet_icon, title = "Payment Method", onClick = {})
            SettingsItem(icon = R.drawable.danger_circle_icon, title = "Privacy", onClick = {})
            SettingsItem(icon = R.drawable.password_icon, title = "Security", onClick = {})

            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Help", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier.padding(bottom = 16.dp))

            SettingsItem(icon = R.drawable.call_icon, title = "Contact Us", onClick = {})
            SettingsItem(icon = R.drawable.document_icon, title = "FAQ", onClick = {})

            Spacer(modifier = Modifier.weight(1f))

            OutlinedButton(
                onClick = { /* Log out action */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                shape = RoundedCornerShape(30.dp),
                border = BorderStroke(1.dp, Color(0xFF6C4DF4)),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color(0xFF6C4DF4)
                )
            ) {
                Text(
                    text = "Log Out",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun SettingsItem(
    icon: Int,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clickable(onClick = onClick)
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(42.dp)
                .background(
                    color = Color(0xFFE7E7E7).copy(alpha = 0.5f),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = title,
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.width(16.dp))

        Text(
            text = title,
            fontSize = 15.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black,
            modifier = Modifier.weight(1f)
        )

        Icon(
            painter = painterResource(id = R.drawable.arrow_icon),
            contentDescription = "Navigate",
            tint = Color.Gray,
            modifier = Modifier.size(20.dp)
        )
    }
}
