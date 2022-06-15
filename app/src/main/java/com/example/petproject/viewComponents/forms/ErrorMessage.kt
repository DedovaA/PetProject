package com.example.petproject.viewComponents.forms

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.error_caption_text_style
import com.example.petproject.consts.uiConsts.error_text_red

@Preview
@Composable
fun ErrorMessage(err:String = ""){
    Text(
        text = err,
        style = error_caption_text_style,
//        fontFamily = FontFamily(Font(R.font.mulish_regular)),
//        fontSize = 12.sp,
//        color = error_text_red,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}

