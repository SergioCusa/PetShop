package com.prueba.petsop.ui.screens.searchScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import com.prueba.petsop.ui.components.tags.CategoryChip

@Composable
fun SearchScreen() {
    var query by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Search", style = MaterialTheme.typography.titleMedium, modifier = Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.height(24.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray, shape = MaterialTheme.shapes.medium)
                .padding(12.dp)
        ) {
            BasicTextField(
                value = query,
                onValueChange = { query = it },
                textStyle = TextStyle(color = Color.DarkGray),
                modifier = Modifier.fillMaxWidth(),
                decorationBox = { innerTextField ->
                    if (query.isEmpty()) Text("Search your Product", color = Color.Gray)
                    innerTextField()
                }
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            CategoryChip("Food", selected = true)
            CategoryChip("Toys", selected = false)
            CategoryChip("Accesories", selected = false)
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Recent", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(12.dp))
        repeat(3) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Royal Canin Persian 500g", color = Color.Gray)
                Box(modifier = Modifier.size(24.dp).background(Color.LightGray))
            }
        }
    }
}
