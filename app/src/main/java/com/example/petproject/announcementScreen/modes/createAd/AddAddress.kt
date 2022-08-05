package com.example.petproject.announcementScreen.modes.createAd

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.announcementScreen.TopBar
import com.example.petproject.consts.uiConsts.petCardBackground
import com.example.petproject.viewComponents.buttons.MainButtonWithEndIcon

@Composable
fun AddAddress(
    topBarText: String
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        TopBar(text = topBarText)
        BoxWithConstraints {
            val width = maxWidth
            Box(modifier = Modifier
                .size(width)
                .background(color = petCardBackground)
            ) {
                //TODO show uploaded photo
            }
        }
        Spacer(modifier = Modifier.weight(1f))
        MainButtonWithEndIcon(
            textButton = "Указать адрес",
            iconResourceId = R.drawable.arrow_toward_white_icon,
            iconDescription = stringResource(R.string.arrow_icon),
            callbackOnClick = { }
        )
    }
}