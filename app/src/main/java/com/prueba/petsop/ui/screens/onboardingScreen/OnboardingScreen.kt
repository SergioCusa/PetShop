package com.prueba.petsop.ui.screens.onboardingScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.components.buttons.PrimaryButton
import com.prueba.petsop.ui.components.navigation.PageIndicator

@Composable
fun OnboardingScreen(
    onGetStartedClick: () -> Unit,
    onProductListClick: () -> Unit,
    onLoginTestClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp, vertical = 32.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Meet your\nanimal needs\nhere",
                style = MaterialTheme.typography.headlineLarge,
                lineHeight = 40.sp
            )

            Spacer(modifier = Modifier.height(24.dp))

            Box(
                modifier = Modifier
                    .height(240.dp)
                    .fillMaxWidth()
                    .background(Color.LightGray, shape = RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Text("Illustration Placeholder")
            }

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = "Get interesting promos here, register your account immediately so you can meet your animal needs.",
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            PageIndicator(currentPage = 1, totalPages = 3)

            Spacer(modifier = Modifier.height(24.dp))

            PrimaryButton(text = "Get Started", onClick = onGetStartedClick)
            Spacer(modifier = Modifier.height(16.dp))
            PrimaryButton(text = "Ver Productos", onClick = onProductListClick)

        }
    }
}
