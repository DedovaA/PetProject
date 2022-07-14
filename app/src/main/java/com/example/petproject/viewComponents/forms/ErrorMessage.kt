package com.example.petproject.viewComponents.forms

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.errorCaptionTextStyle

@Composable
fun ErrorMessage(message: String) {
    Text(
        text = message,
        style = errorCaptionTextStyle,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}
