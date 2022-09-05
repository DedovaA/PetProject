package com.example.petproject.viewComponents.fields

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.*
import com.example.petproject.utils.TextFieldCallback

@Composable
fun PasswordField(
    hint: String,
    textValue: String,
    callbackPassword: TextFieldCallback,
    errorInput: Boolean
) {
    var passwordVisibility by remember { mutableStateOf(false) }

    val iconId = when {
        passwordVisibility -> R.drawable.visible
        else -> R.drawable.invisible
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 10.dp,
        border = when {
            !errorInput -> BorderStroke(2.dp, errorTextRed)
            else -> BorderStroke(0.dp, Color.Transparent)
        }
    ) {
        TextField(
            value = textValue,
            onValueChange = { callbackPassword(it) },
            placeholder = { Text(text = hint) },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = painterResource(iconId),
                        contentDescription = stringResource(R.string.visibility_icon)
                    )
                }
            },
            visualTransformation = if (passwordVisibility) VisualTransformation.None
            else PasswordVisualTransformation(),

            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                trailingIconColor = mainBlue,
                placeholderColor = neutralsGray,
                textColor = validationBlack
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = authFieldTextStyle,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )
    }
}
