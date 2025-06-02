package com.prueba.petsop

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.prueba.petsop.ui.navigation.authNavGraph
import com.prueba.petsop.ui.navigation.onboardingNavGraph
import com.prueba.petsop.ui.navigation.appNavGraph
import com.prueba.petsop.viewmodel.ProductViewModel
import com.prueba.petsop.ui.theme.PetSopTheme

@Composable
fun AppPetShop(viewModel: ProductViewModel) {
    PetSopTheme {
        val navController = rememberNavController()

        NavHost(
            navController = navController,
            startDestination = "onboarding_graph"
        ) {
            onboardingNavGraph(navController)
            authNavGraph(navController)
            appNavGraph(navController)
        }
    }
}