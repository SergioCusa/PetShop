package com.prueba.petsop.ui.components.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ModeSwitchSelector(
    leftText: String,
    rightText: String,
    isRightSelected: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(240.dp)
                .height(45.dp)
                .background(color = MaterialTheme.colorScheme.surfaceVariant, RoundedCornerShape(24.dp))
                .padding(4.dp)
        ) {
            Row(modifier = Modifier.fillMaxSize()) {
                Button(
                    onClick = { onToggle(false) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (!isRightSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                        contentColor = if (!isRightSelected) Color.White else Color.Gray
                    ),
                    shape = RoundedCornerShape(20.dp),
                    elevation = if (!isRightSelected) ButtonDefaults.buttonElevation(2.dp) else ButtonDefaults.buttonElevation(0.dp),
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp)
                ) {
                    Text(
                        leftText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = (14 * 1.5).sp
                    )
                }

                Button(
                    onClick = { onToggle(true) },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = if (isRightSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
                        contentColor = if (isRightSelected) Color.White else Color.Gray
                    ),
                    shape = RoundedCornerShape(20.dp),
                    elevation = if (isRightSelected) ButtonDefaults.buttonElevation(2.dp) else ButtonDefaults.buttonElevation(0.dp),
                    modifier = Modifier.weight(1f).fillMaxHeight(),
                    contentPadding = PaddingValues(horizontal = 6.dp, vertical = 8.dp)
                ) {
                    Text(
                        rightText,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        lineHeight = (14 * 1.5).sp
                    )
                }
            }
        }
    }
}