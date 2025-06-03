package com.prueba.petsop.ui.components.text

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.unit.dp

@Composable
fun ValidateTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    showError: Boolean
) {
    Column(modifier = Modifier.fillMaxWidth()) {

        var wasTouched by remember { mutableStateOf(false) }
        var isSelected by remember { mutableStateOf(false) }

        Box(
            modifier = Modifier
                .onFocusChanged() { focusState ->
                    isSelected = focusState.isFocused
                }
                .height(55.dp)
                .border(
                    width = 1.dp,
                    color =
                        if (showError && wasTouched) MaterialTheme.colorScheme.error
                        else if (isSelected) MaterialTheme.colorScheme.primary
                        else MaterialTheme.colorScheme.outlineVariant,
                    shape = RoundedCornerShape(12.dp)
                )
                .padding(horizontal = 16.dp, vertical = 12.dp)
                .fillMaxWidth()
        ) {
            BasicTextField(
                value = value,
                onValueChange = {
                    onValueChange(it)
                    if (it.isNotEmpty() || !wasTouched) {
                        wasTouched = true
                    }
                },
                textStyle = LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.primary),
                modifier = Modifier.fillMaxWidth(),
                decorationBox = { innerTextField ->
                    if (value.isEmpty()) {
                        Text(
                            text = placeholder,
                            color = MaterialTheme.colorScheme.outline,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    innerTextField()
                },
            )
        }

        if (showError && wasTouched) {
            Text(
                text = "ℹ Required Fields",
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall,
                modifier = Modifier.padding(top = 4.dp, start = 8.dp)
            )
        }
    }
}