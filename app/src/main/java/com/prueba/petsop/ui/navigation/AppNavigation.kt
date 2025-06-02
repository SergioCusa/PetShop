package com.prueba.petsop.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prueba.petsop.ui.screens.homeScreen.HomeScreen
import com.prueba.petsop.ui.screens.notificationScreen.NotificationScreen
import com.prueba.petsop.ui.screens.profileScreen.ProfileScreen
import com.prueba.petsop.ui.screens.searchScreen.SearchScreen

fun NavGraphBuilder.appNavGraph(navController: NavHostController) {
    navigation(startDestination = "home", route = "app") {
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
            NotificationScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("search") {
            SearchScreen()
        }
        composable("cart") {
            SearchScreen()
        }
    }
}
