package com.prueba.petsop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.prueba.petsop.ui.navigation.MainNavigation
import com.prueba.petsop.ui.theme.PetSopTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prueba.petsop.viewmodel.ProductViewModel
import com.prueba.petsop.ui.ProductListScreen
import com.prueba.petsop.ui.screens.FavoritesScreen
import com.prueba.petsop.ui.screens.onboardingScreen.OnboardingScreen

@Composable
fun AppPetShop(viewModel: ProductViewModel) {
    PetSopTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "onboarding"
        ) {
            composable("onboarding") {
                OnboardingScreen(
                    onGetStartedClick = {
                        navController.navigate("auth_graph") {
                            popUpTo("onboarding") { inclusive = true }
                        }
                    },
                    onProductListClick = {
                        navController.navigate("product_list") {
                            popUpTo("onboarding") { inclusive = true }
                        }
                    },
                    onLoginTestClick = {
                        navController.navigate("login_test") {
                            popUpTo("onboarding") { inclusive = true }
                        }
                    }
                )
            }
            composable("product_list") {
                ProductListScreen(
                    viewModel = viewModel,
                    onNavigateToFavorites = {
                        navController.navigate("favorites")
                    }
                )
            }
            composable("favorites") {
                FavoritesScreen(
                    viewModel = viewModel,
                    onNavigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}