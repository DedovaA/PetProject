package com.example.petproject.consts.uiConsts

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.petproject.R

// Set of Material typography styles to start with
val main_button_text_style = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_bold)),
        fontSize = 16.sp,
        color = text_white
    )
val login_switch_button_text_style = TextStyle(
    fontFamily = FontFamily(Font(R.font.mulish_bold)),
    fontSize = 16.sp,
    color = validation_black
)
val transparent_button_text_style = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_semi_bold)),
        fontSize = 16.sp,
        color = validation_black
    )
val auth_field_text_style = TextStyle(
        fontFamily = FontFamily(Font(R.font.mulish_regular)),
        fontSize = 16.sp,

    )
val error_caption_text_style = TextStyle(
    fontFamily = FontFamily(Font(R.font.mulish_regular)),
    fontSize = 12.sp,
    color = error_text_red
)