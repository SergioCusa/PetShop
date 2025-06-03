package com.prueba.petsop.ui.screens.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R
import com.prueba.petsop.ui.components.buttons.PrimaryButton
import com.prueba.petsop.ui.components.icons.FavouriteIcon
import com.prueba.petsop.ui.components.icons.GetBackIcon
import com.prueba.petsop.ui.components.layout.HomeHeader

@Composable
fun ProductDetailScreen(
    onBackClick: () -> Unit,
    onFavouriteClick: () -> Unit,
    onNavigateToCart:() -> Unit
    ) {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 6.dp)
            .verticalScroll(scrollState)
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        HomeHeader(
            onBackClick = onBackClick,
            title = "Product Detail",
            right = true,
            onFavouriteClick = onFavouriteClick
        )

        Spacer(modifier = Modifier.height(30.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(330.dp),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.yellow_product_detail),
                contentDescription = "Photo",
                modifier = Modifier
                    .fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Column(){
            Text(
                text = "Royal Canin Adult",
                style = MaterialTheme.typography.labelMedium.copy(fontSize = 20.sp),
                modifier = Modifier.padding(horizontal = 24.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))
            Text(
                text = "The Persian cat has the longest and densest coat of all cat breeds. This means that it typically needs to consume more skin-health focused nutrients than other cat breeds. That’s why ROYAL CANIN® Persian Adult contains an exclusive complex of nutrients to help the skin’s barrier defence role to maintain good skin and coat health.",
                style = MaterialTheme.typography.bodySmall.copy(color = MaterialTheme.colorScheme.outline, fontSize = 13.sp),
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(30.dp))

            Row(modifier = Modifier
                .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically
            ){
                Spacer(modifier = Modifier.width(10.dp))
                Row(
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.surfaceVariant, shape = RoundedCornerShape(30.dp))
                        .height(50.dp)
                        .width(130.dp)

                ){
                    Text("-")
                    Text("1")
                    Text("+")
                }
                Spacer(modifier = Modifier.width(80.dp))

                Text(
                    text = "$12.99",
                    style = MaterialTheme.typography.labelMedium.copy(fontSize = 28.sp),
                )
                Spacer(modifier = Modifier.width(10.dp))
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        Row(modifier = Modifier.padding(horizontal = 20.dp)){
            PrimaryButton(text = "Add to Cart", onClick = onNavigateToCart)
        }

        Spacer(modifier = Modifier.height(16.dp))

    }
}
