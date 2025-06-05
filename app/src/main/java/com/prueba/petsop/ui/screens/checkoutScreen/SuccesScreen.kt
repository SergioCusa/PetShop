package com.prueba.petsop.ui.screens.checkoutScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.buttons.SaveButton

@Composable
fun SuccesScreen(
    onNavigateToHome: () -> Unit
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 30.dp, vertical = 16.dp)
    ) {
        Spacer(modifier = Modifier.height(40.dp))

        Text(
            text = stringResource(id = R.string.payment_success),
            style = MaterialTheme.typography.labelMedium.copy(fontSize = 40.sp),
        )

        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = stringResource(id = R.string.order_preparing),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.outline
        )

        Spacer(modifier = Modifier.weight(1f))

        SaveButton(
            text = stringResource(id = R.string.go_home),
            enabled = true,
            onClick = onNavigateToHome
        )

        Spacer(modifier = Modifier.height(16.dp))
    }
}