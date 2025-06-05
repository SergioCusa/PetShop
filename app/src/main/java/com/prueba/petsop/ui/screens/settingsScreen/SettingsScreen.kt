package com.prueba.petsop.ui.screens.settingsScreen

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.buttons.LogoutButton
import com.prueba.petsop.ui.components.items.SettingsItem
import com.prueba.petsop.ui.components.layout.HomeHeader


@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onNavigateToAccount: () -> Unit,
    onNavigateToNotification: () -> Unit,
    onNavigateToPaymentMethod: () -> Unit,
    onNavigateToPrivacy: () -> Unit,
    onNavigateToSecurity: () -> Unit,
    onNavigateToFAQ: () -> Unit,
    onLogOutClick: () -> Unit,
    onNavigateToContact: () -> Unit
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
            SettingsItem(icon = R.drawable.notification_icon, title = "Notification", onClick = onNavigateToNotification)
            SettingsItem(icon = R.drawable.wallet_icon, title = "Payment Method", onClick = onNavigateToPaymentMethod)
            SettingsItem(icon = R.drawable.danger_circle_icon, title = "Privacy", onClick = onNavigateToPrivacy)
            SettingsItem(icon = R.drawable.password_icon, title = "Security", onClick = onNavigateToSecurity)

            Spacer(modifier = Modifier.height(32.dp))

            Text(text = "Help", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = Color.Black, modifier = Modifier.padding(bottom = 16.dp))

            SettingsItem(icon = R.drawable.call_icon, title = "Contact Us", onClick = onNavigateToContact)
            SettingsItem(icon = R.drawable.document_icon, title = "FAQ", onClick = onNavigateToFAQ)

            Spacer(modifier = Modifier.weight(1f))

            LogoutButton(
                onClick = onLogOutClick
            )

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

