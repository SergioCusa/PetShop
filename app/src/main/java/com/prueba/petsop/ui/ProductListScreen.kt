package com.prueba.petsop.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale 
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter
import com.prueba.petsop.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(viewModel: ProductViewModel = viewModel()) {
    val products by viewModel.products.collectAsState()

    Scaffold(
        topBar = { TopAppBar(title = { Text("Productos") }) }
    ) { padding ->
        LazyColumn(contentPadding = padding) {
            items(products) { product ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Row(modifier = Modifier.padding(8.dp)) {
                        Image(
                            painter = rememberAsyncImagePainter(product.thumbnail),
                            contentDescription = product.title,
                            modifier = Modifier.size(64.dp),
                            contentScale = ContentScale.Crop
                        )
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(product.title, style = MaterialTheme.typography.titleMedium)
                            Text("$${product.price}", style = MaterialTheme.typography.bodyMedium)
                        }
                    }
                }
            }
        }
    }
}