package com.example.petproject.mainScreen.screenModes.createAdScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.mainScreen.TopBar
import com.example.petproject.viewComponents.buttons.ButtonIcon
import com.example.petproject.viewComponents.buttons.MainButtonWithStarIcon

@Composable
fun PetLocationView(
    topBarText: String
) {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(text = topBarText)
        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(modifier = Modifier.fillMaxSize())
            {
                //TODO display location
            }
            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Transparent)
                    .padding(16.dp)

            ) {
                ButtonIcon(
                    iconResourceId = R.drawable.location_white_icon,
                    iconDescription = "location icon",
                    callbackOnClick = { }
                )
            }
            Box(
                contentAlignment = Alignment.BottomCenter,
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = Color.Transparent)
                    .padding(bottom = 24.dp)
            ) {
                MainButtonWithStarIcon(
                    textButton = "Подтвердить",
                    iconResourceId = R.drawable.check_icon,
                    iconDescription = "check location",
                    callbackOnClick = { }
                )
            }
        }
    }
}