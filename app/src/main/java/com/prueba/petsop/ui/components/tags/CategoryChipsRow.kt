package com.prueba.petsop.ui.components.tags

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.prueba.petsop.R

@Composable
fun CategoryChipsRow(){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.shufle_icon),
            contentDescription = "Shuffle",
            modifier = Modifier
                .height(55.dp)
                .width(55.dp)
        )
        CategoryChip(text = "Food", selected = true)
        CategoryChip(text = "Toys", selected = false)
        CategoryChip(text = "Accessories", selected = false)
    }
}