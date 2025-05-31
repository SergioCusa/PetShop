package com.prueba.petsop.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.googlefonts.GoogleFont
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R

val poppinsFontFamily = FontFamily(
    Font(resId = R.font.poppins_light),
    Font(resId = R.font.poppins_regular),
    Font(resId = R.font.poppins_medium),
    Font(resId = R.font.poppins_semibold),
    Font(resId = R.font.poppins_bold)
)

val AppTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 57.sp
    ),
    titleLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 22.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 16.sp
    ),
    labelLarge = TextStyle(
        fontFamily = poppinsFontFamily,
        fontSize = 14.sp
    )
)
