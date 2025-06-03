package com.prueba.petsop.ui.screens.cartScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.ui.components.buttons.PrimaryButton
import com.prueba.petsop.ui.components.cards.CartProduct
import com.prueba.petsop.ui.components.icons.GetBackIcon
import com.prueba.petsop.ui.components.layout.HomeHeader

@Composable
fun CartScreen(
    onBackClick: () -> Unit,
    onNavigateToPaymentMethod: () -> Unit
) {
    val scrollState = rememberScrollState()

    Column(modifier = Modifier
        .fillMaxWidth()
        .height(900.dp)
        .verticalScroll(scrollState)) {
        Column(
            modifier = Modifier
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            HomeHeader(
                onBackClick = onBackClick,
                title = "Cart"
            )

            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(18.dp),
                modifier = Modifier
                    .padding(horizontal = 16.dp)
                    .height(400.dp)
            ) {
                items(3) {
                    CartProduct()
                    Spacer(modifier = Modifier.height(5.dp))
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .shadow(16.dp, shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp))
                .background(
                    MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(topEnd = 30.dp, topStart = 30.dp)
                )
                .height(270.dp)
                .padding(horizontal = 30.dp, vertical = 20.dp)
        ) {
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text("3 Items",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline)
                Text("$38.97",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Tax",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline)
                Text("$1.99",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.outline)
            }
            Spacer(modifier = Modifier.height(10.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically) {
                Text("Totals",
                    style = MaterialTheme.typography.labelMedium)
                Text("$36.98",
                    style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold))
            }
            Spacer(modifier = Modifier.weight(1f))

            PrimaryButton(text = "Checkout", onClick = onNavigateToPaymentMethod)
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}
