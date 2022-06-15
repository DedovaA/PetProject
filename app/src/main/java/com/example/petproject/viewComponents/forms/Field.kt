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
import com.example.petproject.consts.uiConsts.auth_field_text_style
import com.example.petproject.consts.uiConsts.neutrals_gray
import com.example.petproject.consts.uiConsts.validation_black

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
                placeholderColor = neutrals_gray,
                textColor = validation_black
            ),
            keyboardOptions = KeyboardOptions(keyboardType = inputType),
            textStyle = auth_field_text_style,
            modifier = Modifier.fillMaxWidth()
        )

    }

}
