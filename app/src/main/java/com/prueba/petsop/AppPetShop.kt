package com.prueba.petsop

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.prueba.petsop.ui.navigation.MainNavigation
import com.prueba.petsop.ui.theme.PetSopTheme

@Composable
fun AppPetShop(){
    PetSopTheme {
        Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
            Column(modifier = Modifier.padding(innerPadding)) {
                MainNavigation()
            }
        }
    }
}