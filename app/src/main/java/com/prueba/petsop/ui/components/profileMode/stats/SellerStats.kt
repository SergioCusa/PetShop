package com.prueba.petsop.ui.components.profileMode.stats

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.prueba.petsop.ui.components.items.StatItem

@Composable
fun SellerStats(followers: Int, following: Int, sales: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 24.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(40.dp)
        ) {
            StatItem(value = followers, label = "Followers")
            StatItem(value = following, label = "Following")
            StatItem(value = sales, label = "Sales")
        }
    }
}