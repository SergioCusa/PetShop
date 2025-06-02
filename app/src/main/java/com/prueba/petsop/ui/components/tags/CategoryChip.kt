package com.prueba.petsop.ui.components.tags

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CategoryChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit = {},
    selectedColor: Color = MaterialTheme.colorScheme.primary,
    unselectedColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    selectedTextColor: Color = MaterialTheme.colorScheme.background,
    unselectedTextColor: Color = MaterialTheme.colorScheme.outline
) {
    val background = if (selected) selectedColor else unselectedColor
    val contentColor = if (selected) selectedTextColor else unselectedTextColor

    Box(
        modifier = Modifier
            .background(background, RoundedCornerShape(20.dp))
            .clickable { onClick() }
            .padding(horizontal = 22.dp, vertical = 8.dp)
            .height(35.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = contentColor,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
