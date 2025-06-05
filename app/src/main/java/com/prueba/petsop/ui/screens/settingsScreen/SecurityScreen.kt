package com.prueba.petsop.ui.screens.settingsScreen

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.items.SettingsItem
import com.prueba.petsop.ui.components.layout.HomeHeader

@Composable
fun SecurityScreen(
    onBackClick: () -> Unit,
    onNavigateToChangePassword: () -> Unit,
    onNavigateToChangeEmail: () -> Unit
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
                    title = stringResource(R.string.security)
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

            Text(
                text = stringResource(R.string.security),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 16.dp)
            )

            SettingsItem(
                icon = R.drawable.password_icon,
                title = stringResource(R.string.change_password),
                onClick = onNavigateToChangePassword
            )
            SettingsItem(
                icon = R.drawable.password_icon,
                title = stringResource(R.string.change_email),
                onClick = onNavigateToChangeEmail
            )
        }
    }
}