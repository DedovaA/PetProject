package com.example.petproject.announcementScreen.modes.createAd

import androidx.compose.foundation.layout.*
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petproject.announcementScreen.TopBar

//@Preview
@Composable
fun CreateAd(
) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
//        UploadPhoto("Загрузите фотографию")
//        AddAddress("Укажите адрес")
//        PetLocation("Где вы видели питомца")
        PetDescription("Где вы видели питомца")
    }
}