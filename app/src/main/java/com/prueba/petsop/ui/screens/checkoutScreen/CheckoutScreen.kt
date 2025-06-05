package com.prueba.petsop.ui.screens.checkoutScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.buttons.SaveButton
import com.prueba.petsop.ui.components.buttons.SelectablePayment
import com.prueba.petsop.ui.components.layout.HomeHeader

@Composable
fun CheckoutScreen(
    onBackClick: () -> Unit,
    onSuccesClick: () -> Unit
) {
    var isValid by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Spacer(modifier = Modifier.height(10.dp))

        HomeHeader(
            onBackClick = onBackClick,
            title = stringResource(id = R.string.payment_method)
        )

        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = stringResource(id = R.string.choose_payment_method),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
            )

            Spacer(modifier = Modifier.height(20.dp))

            SelectablePayment(
                onSelectionChanged = { isValid = it },
                opt1 = stringResource(id = R.string.paypal),
                opt2 = stringResource(id = R.string.bank_transfer)
            )

            Spacer(modifier = Modifier.weight(1f))

            SaveButton(
                text = stringResource(id = R.string.checkout),
                enabled = isValid,
                onClick = onSuccesClick
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}