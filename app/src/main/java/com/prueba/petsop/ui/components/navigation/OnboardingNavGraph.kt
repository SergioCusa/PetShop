package com.prueba.petsop.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prueba.petsop.ui.screens.onboardingScreen.OnboardingScreen

fun NavGraphBuilder.onboardingNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "onboarding",
        route = "onboarding_graph"
    ) {
        composable("onboarding") {
            OnboardingScreen(
                onGetStartedClick = {
                    navController.navigate("auth") {
                        popUpTo("onboarding_graph") { inclusive = true }
                    }
                },
                onProductListClick = {
                    navController.navigate("product_list")
                },
                onLoginTestClick = {
                    navController.navigate("login_test")
                }
            )
        }
    }
}
