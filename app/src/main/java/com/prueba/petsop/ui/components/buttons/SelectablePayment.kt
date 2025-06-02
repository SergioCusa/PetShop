package com.prueba.petsop.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import java.nio.file.WatchEvent

@Composable
fun SelectablePayment(
    onSelectionChanged: (Boolean) -> Unit,
    opt1: String,
    opt2: String
) {
    var selectedOption by remember { mutableStateOf<String?>(null) }

    LaunchedEffect(selectedOption) {
        onSelectionChanged(selectedOption != null)
    }

    Column(verticalArrangement = Arrangement.spacedBy(16.dp)) {
        SelectableOption(
            label = opt1,
            selected = selectedOption == "A",
            onClick = { selectedOption = "A" }
        )
        SelectableOption(
            label = opt2,
            selected = selectedOption == "B",
            onClick = { selectedOption = "B" }
        )
    }
}

@Composable
fun SelectableOption(
    label: String,
    selected: Boolean,
    onClick: () -> Unit
) {
    val borderColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant
    val textColor = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outline
    val circleColor = if (selected) MaterialTheme.colorScheme.primary else Color.Transparent
    val circleBorder = if (selected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.outlineVariant

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .border(1.dp, borderColor, shape = RoundedCornerShape(12.dp))
            .clickable { onClick() }
            .padding(horizontal = 16.dp, vertical = 14.dp)
            .height(40.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = label,
            color = textColor,
            style = MaterialTheme.typography.bodyMedium
        )
        Box(
            modifier = Modifier
                .size(20.dp)
                .border(2.dp, circleBorder, shape = CircleShape)
                .background(circleColor, shape = CircleShape)
        )
    }
}
