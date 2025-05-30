package com.prueba.petsop.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prueba.petsop.ui.screens.homeScreen.HomeScreen
import com.prueba.petsop.ui.screens.profileScreen.ProfileScreen

fun NavGraphBuilder.appNavGraph(navController: NavHostController) {
    navigation(startDestination = "home", route = "app") {
        composable("home") {
            HomeScreen(onNavigate = { navController.navigate("profile") })
        }
        composable("profile") {
            ProfileScreen()
        }
    }
}