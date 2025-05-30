package com.prueba.petsop.ui.components.text

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.headlineLarge.copy(lineHeight = 40.sp),
        textAlign = TextAlign.Start
    )
}
