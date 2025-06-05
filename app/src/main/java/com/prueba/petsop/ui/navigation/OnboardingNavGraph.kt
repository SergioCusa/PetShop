package com.prueba.petsop.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prueba.petsop.ui.screens.onboardingScreen.OnboardingScreen

fun NavGraphBuilder.onboardingNavGraph(navController: NavHostController) {
    navigation(startDestination = NavRoutes.ONBOARDING, route = NavRoutes.ONBOARDING_GRAPH) {
        composable(route = NavRoutes.ONBOARDING) {
            OnboardingScreen(
                onGetStartedClick = {
                    navController.navigate(NavRoutes.AUTH_GRAPH)
                },
                onProductListClick = {
                    navController.navigate(NavRoutes.PRODUCT_LIST) 
                },
                onLoginTestClick = {
                    navController.navigate(NavRoutes.LOGIN_TEST)
                }
            )
        }
    }
}