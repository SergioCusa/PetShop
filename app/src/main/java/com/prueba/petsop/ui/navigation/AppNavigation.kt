package com.prueba.petsop.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prueba.petsop.ui.screens.homeScreen.HomeScreen
import com.prueba.petsop.ui.screens.notificationScreen.NotificationScreen
import com.prueba.petsop.ui.screens.profileScreen.ProfileScreen
import com.prueba.petsop.ui.screens.searchScreen.SearchScreen
import com.prueba.petsop.ui.screens.productDetailsScreen.ProductDetailsScreen
import com.prueba.petsop.ui.screens.favoritesScreen.FavoritesScreen
import com.prueba.petsop.ui.screens.productListScreen.ProductListScreen

fun NavGraphBuilder.appNavGraph(navController: NavHostController) {
    navigation(startDestination = "home", route = NavRoutes.APP_GRAPH) {
        composable("home") {
            HomeScreen(
                onNavigateToProfile = { navController.navigate("profile") },
                onNotificationClick = { navController.navigate("notifications") },
                onSearchClick = { navController.navigate("search") },
                onNavigateToPurchase = { navController.navigate("cart") }
            )
        }
        composable("profile") {
            ProfileScreen()
        }
        composable("notifications") {
            NotificationScreen()
        }
        composable("search") {
            SearchScreen()
        }
        composable("cart") {
            SearchScreen()
        }
        composable(route = NavRoutes.PRODUCT_LIST) {
            ProductListScreen(
                viewModel = hiltViewModel(),
                onNavigateToFavorites = { navController.navigate("favorites") }
            )
        }
        composable("product_details/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId")
            ProductDetailsScreen(productId = productId)
        }
        composable("favorites") {
            FavoritesScreen(
                viewModel = hiltViewModel(),
                onNavigateBack = { navController.navigateUp() }
            )
        }
    }
}
