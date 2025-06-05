package com.prueba.petsop.ui.screens.searchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.icons.SimpleIcon
import com.prueba.petsop.ui.components.layout.HomeHeader
import com.prueba.petsop.ui.components.tags.CategoryChipsRow
import com.prueba.petsop.ui.components.text.CustomOutlinedTextField

@Composable
fun SearchScreen(
    onBackClick: () -> Unit
) {
//    var query by remember { mutableStateOf("") }
    var searchProduct by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 6.dp)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        HomeHeader(
            onBackClick = onBackClick,
            title = stringResource(R.string.search)
        )

        Column(modifier = Modifier.padding(horizontal = 20.dp)) {

            Spacer(modifier = Modifier.height(16.dp))

            CustomOutlinedTextField(
                value = searchProduct,
                onValueChange = { searchProduct = it },
                placeholderText = stringResource(R.string.search_your_product),
                icon = Icons.Default.Search,
                modifier = Modifier
                    .padding(0.dp)
            )

            Spacer(modifier = Modifier.height(24.dp))

            CategoryChipsRow()

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                stringResource(R.string.recent),
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(modifier = Modifier.height(12.dp))

            repeat(3) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        stringResource(R.string.royal_canin_persian_500g),
                        style = MaterialTheme.typography.bodyMedium.copy(fontSize = 15.sp),
                        color = MaterialTheme.colorScheme.outline
                    )
                    Box(modifier = Modifier.size(24.dp).background(Color.Transparent)) {
                        SimpleIcon(
                            icon = Icons.Default.Clear
                        )
                    }
                }
            }
        }
    }
}
