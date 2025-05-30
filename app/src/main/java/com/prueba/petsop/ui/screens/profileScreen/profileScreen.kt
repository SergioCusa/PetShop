package com.prueba.petsop.ui.screens.profileScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prueba.petsop.ui.components.tags.CategoryChip

@Composable
fun profileScreen() {
    var selectedTab by remember { mutableStateOf("Product") }

    Column(modifier = Modifier.padding(16.dp)) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CategoryChip("Profile", selected = false)
            CategoryChip("Seller Mode", selected = true)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
                .background(Color(0xFFE1BFA5))
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text("Pittashop", style = MaterialTheme.typography.titleMedium)
        Text("109 Followers")
        Text("992 Following")
        Text("80 Sales")

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            CategoryChip("Product", selected = selectedTab == "Product")
            CategoryChip("Sold", selected = selectedTab == "Sold")
            CategoryChip("Stats", selected = selectedTab == "Stats")
        }

        Spacer(modifier = Modifier.height(12.dp))

        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(modifier = Modifier.size(100.dp).background(Color.Gray))
                Text("RC Kitten")
                Text("$20.99")
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(modifier = Modifier.size(100.dp).background(Color.Gray))
                Text("RC Persian")
                Text("$22.99")
            }
        }
    }
}
