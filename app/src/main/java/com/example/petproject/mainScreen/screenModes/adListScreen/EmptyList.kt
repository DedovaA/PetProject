package com.example.petproject.mainScreen.screenModes.adListScreen

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.authFieldTextStyle
import com.example.petproject.consts.uiConsts.validationGray

//TODO
@Composable
fun EmptyList() {
    Text(
        text = stringResource(R.string.no_ads_yet),
        color = validationGray,
        style = authFieldTextStyle
    )
}