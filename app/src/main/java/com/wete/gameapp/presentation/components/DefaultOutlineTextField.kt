package com.wete.gameapp.presentation.components

import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@ExperimentalMaterial3Api
@Composable
fun DefaultOutlineTextField(
    modifier: Modifier,
    text: String,
    value: String = "",
    icon: ImageVector = Icons.Default.Lock,
    onValueChange: (value: String) -> Unit,
    keyBoarType: KeyboardType = KeyboardType.Text,
    hideText: Boolean = false
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = {onValueChange(it)},
        keyboardOptions = KeyboardOptions(keyboardType = keyBoarType),
        label = {
            Text(text = text)
        },
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = "")
        },
        visualTransformation = if (hideText) PasswordVisualTransformation() else VisualTransformation.None
    )

}