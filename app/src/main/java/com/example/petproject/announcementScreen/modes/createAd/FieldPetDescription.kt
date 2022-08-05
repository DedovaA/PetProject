package com.example.petproject.announcementScreen.modes.createAd

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.authFieldTextStyle
import com.example.petproject.consts.uiConsts.errorTextRed
import com.example.petproject.consts.uiConsts.neutralsGray
import com.example.petproject.consts.uiConsts.validationBlack
import com.example.petproject.utils.TextFieldCallback

@Preview
@Composable
fun FieldPetDescription(
    hint: String = "Название объявления",
    inputType: KeyboardType = KeyboardType.Text,
    textValue: String = "",
    callbackField: TextFieldCallback = {}
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 10.dp,
//        border = when {
//            !errorInput -> BorderStroke(2.dp, errorTextRed)
//            else -> BorderStroke(0.dp, Color.Transparent)
//        }
    ) {
        TextField(
            value = textValue,
            onValueChange = { callbackField(it) },
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
//            singleLine = true
        )
    }
}
