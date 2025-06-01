package com.prueba.petsop.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import com.prueba.petsop.ui.ProductListScreen
import com.prueba.petsop.ui.LoginScreen
import androidx.navigation.compose.composable

@Composable
fun MainNavigation() {
    val navController: NavHostController = rememberNavController()

    NavHost(navController = navController, startDestination = "onboarding_graph") {
        onboardingNavGraph(navController)
        authNavGraph(navController)
        appNavGraph(navController)

        composable("product_list") {
            ProductListScreen()
        }
        composable("login_test") {
            LoginScreen()
        }
    }
}
