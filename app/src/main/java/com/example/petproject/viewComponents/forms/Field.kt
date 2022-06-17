package com.example.petproject.viewComponents.forms

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.authFieldTextStyle
import com.example.petproject.consts.uiConsts.neutralsGray
import com.example.petproject.consts.uiConsts.validationBlack

@Preview
@Composable
fun Field(hint: String = "name", inputType: KeyboardType = KeyboardType.Text) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 10.dp
    ) {
        TextField(
            value = text,
            onValueChange = { text = it },
            placeholder = { Text(text = hint) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                placeholderColor = neutralsGray,
                textColor = validationBlack
            ),
            keyboardOptions = KeyboardOptions(keyboardType = inputType),
            textStyle = authFieldTextStyle,
            modifier = Modifier.fillMaxWidth(),
            singleLine = true
        )

    }

}
