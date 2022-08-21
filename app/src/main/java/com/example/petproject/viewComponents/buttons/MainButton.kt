package com.example.petproject.viewComponents.buttons

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.*

@Composable
fun MainButton(
    text: String,
    callback: () -> Unit
) {
    Button(
        onClick = {
                  callback()
        },
        modifier = Modifier
            .padding(top = 8.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = mainBlue, contentColor = white
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp, pressedElevation = 10.dp
        ),
        shape = smallShape,
        contentPadding = buttonContentPadding
    ) {
        Text(
            text = text, style = mainButtonTextStyle
        )
    }
}
