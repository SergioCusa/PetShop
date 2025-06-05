package com.prueba.petsop.ui.components.icons

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun FooterIcon(
    icon: Int,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val primaryColor = MaterialTheme.colorScheme.primary
    val defaultColor = MaterialTheme.colorScheme.outline

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 8.dp)
            .clickable(onClick = onClick)
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = if (isSelected) primaryColor else defaultColor,
            modifier = Modifier.size(28.dp)
        )
        Spacer(modifier = Modifier.height(4.dp))
        if (isSelected) {
            Box(
                modifier = Modifier
                    .size(6.dp)
                    .background(color = primaryColor, shape = CircleShape)
            )
        } else {
            Spacer(modifier = Modifier.height(6.dp)) // Para alinear íconos
        }
    }
}
