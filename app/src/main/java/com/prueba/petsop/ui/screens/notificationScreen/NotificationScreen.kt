package com.prueba.petsop.ui.screens.notificationScreen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.buttons.NotificationTabSelector
import com.prueba.petsop.ui.components.cards.NotificationItem
import com.prueba.petsop.ui.components.cards.NotificationItemSeller
import com.prueba.petsop.ui.components.layout.HomeHeader

@Composable
fun NotificationScreen(
    onBackClick: () -> Unit
) {
    var selectedTab by remember { mutableStateOf("Activity") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(6.dp)
    ) {

        Spacer(modifier = Modifier.height(20.dp))

        HomeHeader(
            onBackClick = onBackClick,
            title = stringResource(R.string.notification)
        )

        Column(modifier = Modifier.padding(20.dp)) {

            Spacer(modifier = Modifier.height(2.dp))

            NotificationTabSelector(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it }
            )

            Spacer(modifier = Modifier.height(24.dp))

            when (selectedTab) {
                stringResource(R.string.activity) -> {
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                        items(4) {
                            NotificationItem(
                                imageRes = null,
                                title = "SALE 50%",
                                subtitle = "Check the details!"
                            )
                        }
                    }
                }

                "Seller Mode" -> {
                    Column(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                        NotificationItem(
                            imageRes = null,
                            title = "SALE 50%",
                            subtitle = "Check the details!"
                        )
                        NotificationItemSeller(
                            imageRes = null,
                            title = "Momon",
                            subtitle = "Liked your Product",
                            idSeller = R.drawable.seller_momon
                        )
                        NotificationItemSeller(
                            imageRes = null,
                            title = "Ola",
                            subtitle = "Liked your Product",
                            idSeller = R.drawable.seller_ola
                        )
                        NotificationItemSeller(
                            imageRes = null,
                            title = "Raul",
                            subtitle = "Liked your Product",
                            idSeller = R.drawable.seller_raul
                        )
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    LazyColumn(verticalArrangement = Arrangement.spacedBy(18.dp)) {
                        items(3) {
                            NotificationItem(
                                imageRes = null,
                                title = "You Got New Order!",
                                subtitle = "Please arrange delivery"
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(18.dp))
                    NotificationItemSeller(
                        imageRes = null,
                        title = "Vito",
                        subtitle = "Liked your Product",
                        idSeller = R.drawable.seller_vito
                    )
                }
            }
        }
    }
}

