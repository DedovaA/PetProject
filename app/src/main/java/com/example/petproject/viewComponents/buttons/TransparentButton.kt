package com.example.petproject.viewComponents.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.*

@Preview
@Composable
fun TransparentButton(
    text: String = "TransparentButton"
) {
    TextButton(
        onClick = { },
        colors = buttonColors(backgroundColor = Color.Transparent, contentColor = validation_black),
        contentPadding = PaddingValues.Absolute(left = 32.dp, top = 18.dp, right = 32.dp, bottom = 18.dp),
        modifier = Modifier.padding(top = 32.dp)
    ) {
        Text(
            text = text,
            style = transparent_button_text_style
        )
    }
}
