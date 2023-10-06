package com.example.vendorvision.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vendorvision.ui.theme.Morning

@Composable
fun reusableFormTextField(
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    singleLine: Boolean,
    width: Dp,
    height: Dp,
    enabled: Boolean = true
){
    val focusManager = LocalFocusManager.current
    Column() {
        OutlinedTextField(
            value = value ,
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder, fontSize = 13.sp) },
            modifier = Modifier
                .width(width)
                .height(height),
            shape = RoundedCornerShape(5.dp),
            singleLine = singleLine,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                textColor = Morning,
                placeholderColor =Morning,
                focusedBorderColor = Morning,
                unfocusedBorderColor = Morning,
                unfocusedLabelColor = Morning,
                disabledPlaceholderColor = Morning
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next),
            keyboardActions = KeyboardActions(
                onNext = {
                    focusManager.moveFocus(FocusDirection.Down)
                }
            ),
            enabled = enabled
        )
    }
}