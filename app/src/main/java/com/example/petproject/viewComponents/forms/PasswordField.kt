package com.example.petproject.viewComponents.forms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.auth_field_text_style
import com.example.petproject.consts.uiConsts.mainBlue
import com.example.petproject.consts.uiConsts.neutrals_gray
import com.example.petproject.consts.uiConsts.validation_black

@Preview
@Composable
fun PasswordField (hint: String = "Password") {
    var password by rememberSaveable { mutableStateOf("") }
    var passwordVisibility by remember { mutableStateOf(false) }
    val icon = if (passwordVisibility)
        painterResource(id = R.drawable.visible)
    else painterResource(id = R.drawable.invisible)

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 10.dp
    ) {
        TextField(
            value = password,
            onValueChange = { password = it },
            placeholder = { Text(text = hint) },
            trailingIcon = {
                IconButton(onClick = {
                    passwordVisibility = !passwordVisibility
                }) {
                    Icon(
                        painter = icon,
                        contentDescription = "Visibility Icon"
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
                placeholderColor = neutrals_gray,
                textColor = validation_black
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            textStyle = auth_field_text_style,
            modifier = Modifier.fillMaxWidth()
        )
    }

}


