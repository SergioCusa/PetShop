package com.prueba.petsop.ui.screens.onboardingScreen

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.components.buttons.PrimaryButton
import com.prueba.petsop.ui.components.navigation.PageIndicator
import com.prueba.petsop.ui.components.screnHeader.ScreenHeader
import com.prueba.petsop.R


@Composable
fun OnboardingScreen(
    onGetStartedClick: () -> Unit,
    onProductListClick: () -> Unit,
    onLoginTestClick: () -> Unit
) {
    BackHandler {
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ScreenHeader(
            title = stringResource(id = R.string.onboarding_title),
            subtitle = stringResource(id = R.string.onboarding_subtitle),
            imageRes = R.drawable.onboarding_illustration
        )


        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PageIndicator(currentPage = 1, totalPages = 3)

            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(text = "Get Started", onClick = onGetStartedClick)
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(text = "Ver Productos", onClick = onProductListClick)

        }
    }
}
