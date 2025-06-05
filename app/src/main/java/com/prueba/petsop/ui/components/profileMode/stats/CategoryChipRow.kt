package com.prueba.petsop.ui.components.profileMode.stats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prueba.petsop.ui.components.tags.CategoryChip

@Composable
fun CategoryChipRow(
    options: List<String>,
    selected: String,
    onSelectedChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = modifier
            .padding(top = 24.dp)
    ) {
        options.forEach { option ->
            CategoryChip(
                text = option,
                selected = option == selected,
                onClick = { onSelectedChange(option) }
            )
        }
    }
}