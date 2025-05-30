package com.prueba.petsop.ui.components.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit = {},
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = Color(0xFFF5F5F5),
    selectedTextColor: Color = Color.White,
    unselectedTextColor: Color = Color.Gray
) {
    val background = if (selected) selectedColor else unselectedColor
    val contentColor = if (selected) selectedTextColor else unselectedTextColor

    Box(
        modifier = Modifier
            .background(background, RoundedCornerShape(20.dp))
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        Text(
            text = text,
            color = contentColor,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
