package com.prueba.petsop.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = PurplePrimary,
    onPrimary = White,
    background = White,
    surface = White,
    onBackground = Black,
    onSurface = Black,
    error = ErrorRed,

    // Grises:
    outline = GrayB3,                   // útil para bordes
    outlineVariant = GrayE5,           // otro para bordes o inputs
    surfaceVariant = GrayF8,           // fondo gris claro
    onSurfaceVariant = Gray89,         // texto secundario
    inverseSurface = GrayD9,           // fondos alternativos
    inverseOnSurface = GrayB3          // texto sobre gris
)

@Composable
fun PetSopTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = AppTypography,
        shapes = MaterialTheme.shapes,
        content = content
    )
}