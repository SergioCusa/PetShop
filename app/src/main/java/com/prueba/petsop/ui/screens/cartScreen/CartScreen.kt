package com.prueba.petsop.ui.screens.cartScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.prueba.petsop.ui.components.buttons.PrimaryButton

@Composable
fun CartScreen(
    onBackClick: () -> Unit,
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text("Cart", style = MaterialTheme.typography.titleMedium)

        Spacer(modifier = Modifier.height(24.dp))

        repeat(3) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.LightGray, shape = RoundedCornerShape(16.dp))
                    .padding(16.dp)
                    .padding(bottom = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier
                    .size(64.dp)
                    .background(Color.Gray)) // Image placeholder
                Column {
                    Text("Royal Canin Adult", style = MaterialTheme.typography.bodyLarge)
                    Text("for 2–3 years", style = MaterialTheme.typography.bodySmall)
                    Text("$12.99", color = MaterialTheme.colorScheme.primary)
                }
                Box(modifier = Modifier
                    .size(32.dp)
                    .background(Color.Red)) // Trash placeholder
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Column {
            Text("3 Items\t\t\t\t\t\t\t\t\t$38.97")
            Text("Tax\t\t\t\t\t\t\t\t\t\t\t\t$1.99")
            Text("Totals", style = MaterialTheme.typography.titleMedium)
            Text("$36.98", style = MaterialTheme.typography.headlineMedium)
        }

        Spacer(modifier = Modifier.height(24.dp))

        PrimaryButton(text = "Checkout", onClick = {})
    }
}
