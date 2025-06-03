package com.prueba.petsop.ui.components.layout

import android.R.bool
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prueba.petsop.ui.components.icons.GetBackIcon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text


import androidx.compose.foundation.layout.fillMaxWidth

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.components.icons.FavouriteIcon

@Composable
fun HomeHeader(
    onBackClick: () -> Unit,
    title: String,
    right: Boolean = false,
    onFavouriteClick: () -> Unit = {}
){
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleMedium.copy(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ),
            modifier = Modifier
                .align(Alignment.Center)
        )

        GetBackIcon(
            onClick = onBackClick,
            modifier = Modifier
                .align(Alignment.CenterStart)
        )
        Box(
            modifier = Modifier
                .align(Alignment.CenterEnd)
        ) {
            if(right){
                FavouriteIcon(onClick = onFavouriteClick)
            }
        }
    }

}