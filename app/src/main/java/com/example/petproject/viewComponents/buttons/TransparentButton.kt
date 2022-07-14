package com.example.petproject.viewComponents.buttons

import androidx.compose.foundation.layout.padding
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.buttonContentPadding
import com.example.petproject.consts.uiConsts.transparentButtonTextStyle
import com.example.petproject.consts.uiConsts.validationBlack

@Composable
fun TransparentButton(
    text: String
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
