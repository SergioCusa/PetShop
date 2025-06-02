package com.prueba.petsop.ui.components.layout

import android.R.attr.password
import android.R.attr.text
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.ui.text.input.KeyboardType

import androidx.compose.material.icons.filled.MailOutline
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.*
import androidx.compose.runtime.*

import com.prueba.petsop.ui.components.buttons.PrimaryButton
import com.prueba.petsop.ui.components.details.ThinHorizontalLine
import com.prueba.petsop.ui.components.text.CustomOutlinedTextField
import com.prueba.petsop.ui.components.text.SubtitleText
import com.prueba.petsop.ui.components.text.TitleText
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import com.prueba.petsop.ui.components.icons.FooterIcon
import com.prueba.petsop.ui.components.icons.FooterItem
import com.prueba.petsop.ui.components.icons.SimpleIcon

@Composable
fun ModalLocation(
) {
    var searchLocation by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ){
        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .height(5.dp)
            .width(30.dp)
            .background(MaterialTheme.colorScheme.outlineVariant)
        ){}
        Spacer(modifier = Modifier.height(13.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 13.dp)
        ){
            Text(
                text = "Location",
                style = MaterialTheme.typography.labelMedium,
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        CustomOutlinedTextField(
            value = searchLocation,
            onValueChange = { searchLocation = it },
            placeholderText = "Search Your Location",
            icon = Icons.Default.Search,
            modifier = Modifier
                .padding(10.dp)
        )
    }
    Spacer(modifier = Modifier.height(15.dp))
    ThinHorizontalLine()
    Spacer(modifier = Modifier.height(25.dp))

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 25.dp)
    ){
        SimpleIcon(
            icon = Icons.Default.LocationOn,
        )

        Spacer(modifier = Modifier.width(20.dp))

        Column(modifier = Modifier
            .width(216.dp)){
            Text(
                text = "Track your Location",
                style = MaterialTheme.typography.labelLarge,
            )
            Text(
                text = "automatically selects your current location",
                style = MaterialTheme.typography.bodyMedium.copy(MaterialTheme.colorScheme.outline),
            )
        }
    }
}

