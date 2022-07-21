package com.example.petproject.consts.uiConsts

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import com.example.petproject.R

// Set of Material typography styles to start with
val mainButtonTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.mulish_bold)),
    fontSize = 16.sp,
    color = textWhite
)
val loginSwitchButtonTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.mulish_bold)),
    fontSize = 16.sp,
    color = validationBlack
)
val transparentButtonTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.mulish_semi_bold)),
    fontSize = 16.sp,
    color = validationBlack
)
val authFieldTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.mulish_regular)),
    fontSize = 16.sp
)
val errorCaptionTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.mulish_regular)),
    fontSize = 12.sp,
    color = errorTextRed
)
val adDescriptionTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.mulish_regular)),
    fontSize = 12.sp,
    color = validationBlack
)
val adLocationTextStyle = TextStyle(
    fontFamily = FontFamily(Font(R.font.mulish_regular)),
    fontSize = 12.sp,
    color = neutralsGray
)
