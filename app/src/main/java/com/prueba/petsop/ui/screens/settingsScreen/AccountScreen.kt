package com.prueba.petsop.ui.screens.settingsScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.banners.ProfileBanner
import com.prueba.petsop.ui.components.layout.HomeHeader

@Composable
fun AccountScreen(
    onBackClick: () -> Unit
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
                    title = "Account"
                )
            }
        },
        containerColor = Color.White
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = innerPadding.calculateTopPadding() - 20.dp)
        ) {
            ProfileBanner(
                backgroundImageRes = R.drawable.banner_profile,
                tintColor = Color(0xFFF8F8F8),
                iconRes = R.drawable.profile_avatar_abduldul,
                nameUser = "Abduldul"
            )
        }
    }
}