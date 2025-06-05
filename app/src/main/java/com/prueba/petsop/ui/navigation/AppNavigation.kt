package com.prueba.petsop.ui.navigation

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.prueba.petsop.ui.screens.authScreens.loginScreen.LoginScreen
import com.prueba.petsop.ui.screens.cartScreen.CartScreen
import com.prueba.petsop.ui.screens.checkoutScreen.CheckoutScreen
import com.prueba.petsop.ui.screens.checkoutScreen.SuccesScreen
import com.prueba.petsop.ui.screens.favoritesScreen.FavoritesScreen
import com.prueba.petsop.ui.screens.homeScreen.BestSellerScreen
import com.prueba.petsop.ui.screens.homeScreen.HomeScreen
import com.prueba.petsop.ui.screens.notificationScreen.NotificationScreen
import com.prueba.petsop.ui.screens.paymentMethodScreen.PaymentMethodScreen
import com.prueba.petsop.ui.screens.product.ProductDetailScreen
import com.prueba.petsop.ui.screens.productDetailsScreen.ProductDetailsScreen
import com.prueba.petsop.ui.screens.productListScreen.ProductListScreen
import com.prueba.petsop.ui.screens.profileScreen.ProfileScreen
import com.prueba.petsop.ui.screens.searchScreen.SearchScreen
import com.prueba.petsop.ui.screens.settingsScreen.AccountScreen
import com.prueba.petsop.ui.screens.settingsScreen.ChangeEmailScreen
import com.prueba.petsop.ui.screens.settingsScreen.ChangePasswordScreen
import com.prueba.petsop.ui.screens.settingsScreen.ContactScreen
import com.prueba.petsop.ui.screens.settingsScreen.FAQScreen
import com.prueba.petsop.ui.screens.settingsScreen.PrivacyScreen
import com.prueba.petsop.ui.screens.settingsScreen.ProfileNotificationScreen
import com.prueba.petsop.ui.screens.settingsScreen.SecurityScreen
import com.prueba.petsop.ui.screens.settingsScreen.SettingsScreen

fun NavGraphBuilder.appNavGraph(navController: NavHostController) {
    navigation(startDestination = "home", route = NavRoutes.APP_GRAPH) {
        composable("home") {
            HomeScreen(
                viewModel = hiltViewModel(),
                onNavigateToProfile = { navController.navigate("profile") },
                onNotificationClick = { navController.navigate("notifications") },
                onSearchClick = { navController.navigate("search") },
                onNavigateToPurchase = { navController.navigate("cart") },
                onNavigateToBestSeller = { navController.navigate("best-seller") },
                onNavigateToProductDetail = { navController.navigate("product-detail") },
                onNavigateToFavorites = { navController.navigate("favorites") }
            )
        }
        composable("profile") {
            ProfileScreen(
                onNavigateToProductDetail = { navController.navigate("product-detail") },
                onNavigateToPurchase = { navController.navigate("cart") },
                onNavigateToHome = { navController.navigate("home") },
                onNavigateToSettings = { navController.navigate("settings") }
            )
        }
        composable("notifications") {
            NotificationScreen(onBackClick = { navController.popBackStack() })
        }
        composable("search") {
            SearchScreen(onBackClick = { navController.popBackStack() })
        }
        composable("cart") {
            CartScreen(
                onBackClick = { navController.popBackStack() },
                onNavigateToPaymentMethod = { navController.navigate("payment-method") }
            )
        }
        composable(route = NavRoutes.PRODUCT_LIST) {
            ProductListScreen(
                viewModel = hiltViewModel(),
                onNavigateToFavorites = { navController.navigate("favorites") }
            )
        }

        //Navegacion de rama main
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

        // Navegacion de rama home-page
        composable("best-seller") {
            BestSellerScreen(
                onNavigateToProductDetail = { navController.navigate("product-detail") },
                onBackClick = { navController.popBackStack() })
        }
        composable("product-detail") {
            ProductDetailScreen(
                onBackClick = { navController.popBackStack() },
                onFavouriteClick = { println("Added to favourites") },
                onNavigateToCart = { navController.navigate("cart") })
        }

        // Navegacion Payment Method
        composable("payment-method") {
            PaymentMethodScreen(
                onBackClick = { navController.popBackStack() },
                onCheckoutClick = { navController.navigate("checkout") }
            )
        }

        composable("checkout") {
            CheckoutScreen(
                onBackClick = { navController.popBackStack() },
                onSuccesClick = { navController.navigate("succes") })
        }

        composable("succes") {
            SuccesScreen(onNavigateToHome = { navController.navigate("home") })
        }

        composable("settings") {
            SettingsScreen(
                onBackClick = { navController.popBackStack() },
                onNavigateToAccount = { navController.navigate("account") },
                onNavigateToNotification = { navController.navigate("profile-notification") },
                onNavigateToPaymentMethod = { navController.navigate("payment-method") },
                onNavigateToPrivacy = { navController.navigate("privacy") },
                onNavigateToSecurity = { navController.navigate("security") },
                onNavigateToFAQ = { navController.navigate("faq") },
                onNavigateToContact = { navController.navigate(("contact")) },
                onLogOutClick = {
                    navController.navigate(NavRoutes.LOGIN) {
                        popUpTo(NavRoutes.APP_GRAPH) {
                            inclusive = true
                        }
                    }
                }

            )
        }
         composable("account") {
          AccountScreen(
              onBackClick = { navController.popBackStack() }
          )
        }

        composable("profile-notification") {
            ProfileNotificationScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("privacy") {
            PrivacyScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable("security") {
            SecurityScreen(
                onBackClick = { navController.popBackStack() },
                onNavigateToChangePassword = { navController.navigate("change-password") },
                onNavigateToChangeEmail = { navController.navigate("change-email") }
            )
        }

         composable("change-password") {
             ChangePasswordScreen(
                 onBackClick = { navController.popBackStack() },
                 onNavigateToSettings = { navController.navigate("settings")}
             )
         }

        composable("change-email") {
             ChangeEmailScreen(
                 onBackClick = { navController.popBackStack() },
                 onNavigateToSettings = { navController.navigate("settings")}
             )
         }

        composable("faq") {
            FAQScreen(
                onBackClick = { navController.popBackStack() },
            )
        }

        composable("contact"){
            ContactScreen(
                onBackClick = { navController.popBackStack() }
            )
        }

        composable(NavRoutes.LOGIN) {
            LoginScreen(
                onLoginClick = { navController.navigate(NavRoutes.APP_GRAPH) },
                onRegisterClick = { navController.navigate(NavRoutes.REGISTER) },
                onForgotClick = { navController.navigate(NavRoutes.FORGOT) },
                onBackClick = { navController.popBackStack() } 
            )
        }
    }
}