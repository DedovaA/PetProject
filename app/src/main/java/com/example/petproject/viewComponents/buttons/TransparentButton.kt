package com.example.petproject.viewComponents.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.*

@Preview
@Composable
fun TransparentButton(
    text: String = "TransparentButton"
) {
    TextButton(
        onClick = { },
        colors = buttonColors(backgroundColor = Color.Transparent, contentColor = validationBlack),
        contentPadding = buttonContentPadding,
        modifier = Modifier.padding(top = 32.dp)
    ) {
        Text(
            text = text,
            style = transparentButtonTextStyle
        )
    }
}
