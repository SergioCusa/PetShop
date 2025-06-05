package com.prueba.petsop.ui.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prueba.petsop.ui.screens.authScreens.forgotPassScreen.ForgotPasswordScreen
import com.prueba.petsop.ui.screens.authScreens.loginScreen.LoginScreen
import com.prueba.petsop.ui.screens.authScreens.registerScreen.RegisterScreen
import com.prueba.petsop.ui.LoginScreen as LoginTestScreen

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(startDestination = NavRoutes.LOGIN, route = NavRoutes.AUTH_GRAPH) {
        composable(NavRoutes.LOGIN) {
            LoginScreen(
                onLoginClick = { navController.navigate(NavRoutes.APP_GRAPH)},
                onRegisterClick = { navController.navigate(NavRoutes.REGISTER) },
                onForgotClick = { navController.navigate(NavRoutes.FORGOT) },
                onBackClick = { navController.popBackStack() }
            )
        }
        
        composable(NavRoutes.LOGIN_TEST) {
            LoginTestScreen()
        }

        composable(NavRoutes.REGISTER) {
            RegisterScreen(
                onHaveAcountClick = { navController.navigate(NavRoutes.LOGIN) },
                onLoginClick = {navController.navigate(NavRoutes.APP_GRAPH)}
            )
        }

        composable(NavRoutes.FORGOT) {
            ForgotPasswordScreen(
                onHaveAcountClick = {navController.navigate(NavRoutes.LOGIN)},
                onResetConfirmed = {navController.popBackStack() }
            )
        }
    }
}