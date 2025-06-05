package com.prueba.petsop.ui.screens.settingsScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
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
import com.prueba.petsop.ui.components.buttons.NotificationSwitch
import com.prueba.petsop.ui.components.layout.HomeHeader

@Composable
fun ProfileNotificationScreen(
    onBackClick: () -> Unit
) {
    var likedPostEnabled by remember { mutableStateOf(true) }
    var newMessageEnabled by remember { mutableStateOf(true) }
    var itemSoldEnabled by remember { mutableStateOf(true) }

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
                    title = "Notification"
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
            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Social",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Liked Post",
                    fontSize = 14.sp,
                    color = Color.Black
                )
                NotificationSwitch(
                    checked = likedPostEnabled,
                    onCheckedChange = { likedPostEnabled = it }
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "New Message",
                    fontSize = 14.sp,
                    color = Color.Black
                )
                NotificationSwitch(
                    checked = newMessageEnabled,
                    onCheckedChange = { newMessageEnabled = it }
                )
            }


            Text(
                text = "Store",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Item Sold",
                    fontSize = 14.sp,
                    color = Color.Black
                )
                NotificationSwitch(
                    checked = itemSoldEnabled,
                    onCheckedChange = { itemSoldEnabled = it }
                )
            }
        }
    }
}