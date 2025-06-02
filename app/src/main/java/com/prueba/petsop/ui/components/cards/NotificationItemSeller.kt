package com.prueba.petsop.ui.components.cards

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.prueba.petsop.R

@Composable
fun NotificationItemSeller(imageRes: Int?, title: String, subtitle: String, idSeller: Int) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color.LightGray, CircleShape)
        ) {
            Image(
                painter = painterResource(id = idSeller),
                contentDescription = "Promo",
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.width(12.dp))

        Column(modifier = Modifier.weight(1f)) {
            Text(text = title, style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.SemiBold))
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = subtitle, style = MaterialTheme.typography.bodySmall, color = Color.Gray)
        }

        Box(
            modifier = Modifier
                .size(48.dp)
                .background(Color.LightGray, CircleShape)
        ) {
            Image(
                painter = painterResource(id = R.drawable.notification_item_photo),
                contentDescription = "Promo",
                modifier = Modifier
                    .fillMaxSize()
            )
        }
    }
}
