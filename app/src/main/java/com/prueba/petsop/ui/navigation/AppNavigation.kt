package com.prueba.petsop.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prueba.petsop.ui.screens.homeScreen.HomeScreen
import com.prueba.petsop.ui.screens.notificationScreen.NotificationScreen
import com.prueba.petsop.ui.screens.profileScreen.profileScreen

fun NavGraphBuilder.appNavGraph(navController: NavHostController) {
    navigation(startDestination = "home", route = "app") {
        composable("home") {
            HomeScreen(
                onNavigateToProfile = { navController.navigate("profile") },
                onNotificationClick = { navController.navigate("notifications") }
            )
        }
        composable("profile") {
            profileScreen()
        }
        composable("notifications") {
            NotificationScreen()
        }
    }
}
