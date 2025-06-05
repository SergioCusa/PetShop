package com.prueba.petsop.ui.components.banners

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prueba.petsop.R

@Composable
fun ProfileBanner(
    backgroundImageRes: Int,
    tintColor: Color,
    iconRes: Int,
    nameUser: String,
    showEditButtons: Boolean = false,
    onEditBannerClick: (() -> Unit)? = null,
    onEditProfileClick: (() -> Unit)? = null
) {
    Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.TopCenter) {
        Box(
            modifier = Modifier
                .padding(top = 16.5.dp)
                .width(327.dp)
                .height(159.dp)
                .clip(RoundedCornerShape(24.dp))
        ) {
            Image(
                painter = painterResource(id = backgroundImageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                colorFilter = ColorFilter.tint(tintColor, BlendMode.Multiply),
                modifier = Modifier.fillMaxSize()
            )

            if (showEditButtons) {
                Button(
                    onClick = { onEditBannerClick?.invoke() },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(12.dp)
                        .size(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    contentPadding = PaddingValues(0.dp),
                    shape = CircleShape
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.edit_icon),
                        contentDescription = "Edit Banner",
                        tint = Color.Black,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .size(100.dp)
                .offset(y = 125.5.dp)
        ) {
            Image(
                painter = painterResource(id = iconRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize()
                    .clip(CircleShape)
            )

            if (showEditButtons)
                Button(
                    onClick = { onEditProfileClick?.invoke() },
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .size(24.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    contentPadding = PaddingValues(0.dp),
                    shape = CircleShape
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.edit_icon),
                        contentDescription = "Edit Profile Picture",
                        tint = Color.Black,
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
        }
    Text(
        nameUser,
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentWidth(Alignment.CenterHorizontally)
            .padding(top = 74.dp)
    )
}