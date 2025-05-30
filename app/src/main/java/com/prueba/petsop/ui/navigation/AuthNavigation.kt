package com.prueba.petsop.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prueba.petsop.ui.screens.authScreens.forgotPassScreen.ForgotPasswordScreen
import com.prueba.petsop.ui.screens.authScreens.loginScreen.LoginScreen
import com.prueba.petsop.ui.screens.authScreens.registerScreen.RegisterScreen


fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(startDestination = "login", route = "auth") {
        composable("login") {
            LoginScreen(
                onLoginClick = { navController.navigate("app") },
                onRegisterClick = { navController.navigate("register") },
                onForgotClick = { navController.navigate("forgot") }
            )
        }
        composable("register") {
            RegisterScreen(onBackClick = { navController.popBackStack() })
        }
        composable("forgot") {
            ForgotPasswordScreen(onBackClick = { navController.popBackStack() })
        }
    }


}