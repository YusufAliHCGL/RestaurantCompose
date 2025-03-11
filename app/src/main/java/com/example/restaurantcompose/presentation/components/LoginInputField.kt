package com.example.restaurantcompose.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun LoginInputField(
    modifier: Modifier = Modifier,
    text: String,
    hint: String,
    icon: Int,
    contentDescription: String,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    isVisualTransformation: Boolean,
    onTextValueChanged: (String) -> Unit
) {
    TextField(
        value = text,
        onValueChange = onTextValueChanged,
        label = {
            Text(
                text = hint,
                color = Color(0xFFBAC0CB),
                fontWeight = FontWeight.W400,
                fontSize = 16.sp
            )
        },
        leadingIcon = {
            Icon(
                painter = painterResource(id = icon),
                contentDescription = contentDescription,
                modifier = Modifier.size(16.dp),
                tint = Color(0xFFBAC0CB)
            )
        },
        textStyle = TextStyle(
            color = Color.Black,
            fontWeight = FontWeight.W400,
            fontSize = 16.sp
        ),
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation =
        if (isVisualTransformation)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,
        singleLine = true,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.Transparent,
            focusedContainerColor = Color.Transparent,
            unfocusedIndicatorColor = Color.LightGray,
            focusedIndicatorColor = Color.LightGray
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
    )
}