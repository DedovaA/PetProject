package com.example.petproject.announcementScreen.modes.createAd

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.announcementScreen.TopBar
import com.example.petproject.statesEnum.PetIconButtonType
import com.example.petproject.viewComponents.buttons.PetButtonIconVertical

@Composable
fun PetDescription(
    topBarText: String
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(text = topBarText)
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                PetButtonIconVertical(petIconButtonType = PetIconButtonType.CatTypeIconButton, callbackPetIconType = { })
                PetButtonIconVertical(petIconButtonType = PetIconButtonType.DogTypeIconButton, callbackPetIconType = { })
                PetButtonIconVertical(petIconButtonType = PetIconButtonType.BunnyTypeIconButton, callbackPetIconType = { })
            }
        }
    }
}