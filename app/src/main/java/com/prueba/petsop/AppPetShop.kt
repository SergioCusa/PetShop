package com.prueba.petsop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.prueba.petsop.ui.navigation.MainNavigation
import com.prueba.petsop.ui.theme.PetSopTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.prueba.petsop.viewmodel.ProductViewModel
import com.prueba.petsop.ui.ProductListScreen
import com.prueba.petsop.ui.screens.FavoritesScreen

@Composable
fun AppPetShop(viewModel: ProductViewModel) {
    PetSopTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = MainNavigation.Products.route
        ) {
            composable(MainNavigation.Products.route) {
                ProductListScreen(
                    viewModel = viewModel,
                    onNavigateToFavorites = {
                        navController.navigate(MainNavigation.Favorites.route)
                    }
                )
            }
            composable(MainNavigation.Favorites.route) {
                FavoritesScreen(
                    viewModel = viewModel,
                    onNavigateBack = {
                        navController.navigateUp()
                    }
                )
            }
        }
    }
}