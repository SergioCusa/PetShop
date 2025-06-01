package com.prueba.petsop.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.prueba.petsop.ui.ProductListScreen
import com.prueba.petsop.ui.LoginScreen
import com.prueba.petsop.viewmodel.ProductViewModel

@Composable
fun MainNavigation(viewModel: ProductViewModel) {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "onboarding_graph") {
        onboardingNavGraph(navController)
        authNavGraph(navController)
        appNavGraph(navController)

        composable("product_list") {
            ProductListScreen(
                viewModel = viewModel,
                onNavigateToFavorites = {
                    navController.navigate(MainNavigation.Favorites.route)
                }
            )
        }
        composable("login_test") {
            LoginScreen()
        }
    }
}

sealed class MainNavigation(val route: String) {
    object Products : MainNavigation("products")
    object Favorites : MainNavigation("favorites")
}
