package com.prueba.petsop.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prueba.petsop.ui.screens.homeScreen.BestSellerScreen
import com.prueba.petsop.ui.screens.homeScreen.HomeScreen
import com.prueba.petsop.ui.screens.notificationScreen.NotificationScreen
import com.prueba.petsop.ui.screens.profileScreen.ProfileScreen
import com.prueba.petsop.ui.screens.searchScreen.SearchScreen
import com.prueba.petsop.ui.screens.product.ProductDetailScreen


fun NavGraphBuilder.appNavGraph(navController: NavHostController) {
    navigation(startDestination = "home", route = "app") {
        composable("home") {
            HomeScreen(
                onNavigateToProfile = { navController.navigate("profile") },
                onNotificationClick = { navController.navigate("notifications") },
                onSearchClick = { navController.navigate("search") },
                onNavigateToPurchase = { navController.navigate("cart") },
                onNavigateToBestSeller = { navController.navigate("best-seller") },
                onNavigateToProductDetail = { navController.navigate("product-detail") }
            )
        }
        composable("profile") {
            ProfileScreen(
                onNavigateToProductDetail = { navController.navigate("product-detail") }
            )
        }
        composable("notifications") {
            NotificationScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("search") {
            SearchScreen(onBackClick = { navController.popBackStack() })
        }
        composable("cart") {
            SearchScreen(onBackClick = { navController.popBackStack() })
        }
        composable("best-seller") {
            BestSellerScreen(onNavigateToProductDetail = { navController.navigate("product-detail") }, onBackClick = { navController.popBackStack() })
        }
        composable("product-detail") {
            ProductDetailScreen(onBackClick = { navController.popBackStack() }, onFavouriteClick = { println("Added to favourites") })
        }
    }
}
