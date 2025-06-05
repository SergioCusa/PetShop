package com.prueba.petsop.ui.screens.profileScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.buttons.ModeSwitchSelector
import com.prueba.petsop.ui.components.icons.FooterItem
import com.prueba.petsop.ui.components.layout.BottomNavBar
import com.prueba.petsop.ui.components.profileMode.PersonalProfileView
import com.prueba.petsop.ui.components.profileMode.SellerProfileView


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
                    leftText = stringResource(id = R.string.profile),
                    rightText = stringResource(id = R.string.seller_mode),
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
fun Modifier.alignCenter(): Modifier = this.then(
    Modifier.fillMaxWidth().wrapContentWidth(Alignment.CenterHorizontally)
)

