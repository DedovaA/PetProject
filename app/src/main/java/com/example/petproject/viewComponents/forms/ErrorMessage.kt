package com.example.petproject.viewComponents.forms

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.errorCaptionTextStyle

//@Preview
@Composable
fun ErrorMessage(err:String){
    Text(
        text = err,
        style = errorCaptionTextStyle,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

