package com.prueba.petsop.ui.screens.settingsScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SettingsScreen() {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Settings Page", style = MaterialTheme.typography.titleMedium)
        Spacer(modifier = Modifier.height(24.dp))

        SettingsItem("Account")
        SettingsItem("Address")
        SettingsItem("Notification")
        SettingsItem("Payment Method")
        SettingsItem("Privacy")
        SettingsItem("Security")

        Spacer(modifier = Modifier.height(24.dp))

        Text("Help", style = MaterialTheme.typography.titleMedium)

        SettingsItem("Contact Us")
        SettingsItem("FAQ")

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Log Out")
        }
    }
}

@Composable
fun SettingsItem(label: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(label)
        Box(modifier = Modifier.size(24.dp).background(Color.Gray))
    }
}
