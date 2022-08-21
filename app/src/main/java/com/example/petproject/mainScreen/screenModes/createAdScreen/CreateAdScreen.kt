package com.example.petproject.mainScreen.screenModes.createAdScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.example.petproject.mainScreen.MainScreenViewModel
import com.example.petproject.statesEnum.PetType

@Composable
fun CreateAdScreen(viewModel: MainScreenViewModel) {
    val lostPetType = viewModel.adPetType.observeAsState(PetType.All)
    val lostPetAddress = viewModel.adAddress.observeAsState()
    val lostPetDescription = viewModel.adDescription.observeAsState("")
    val lostPetHeader = viewModel.adHeader.observeAsState("")
    val lostPetPhoto = viewModel.adPhoto.observeAsState()
    val lostPetLocation = viewModel.adLocation.observeAsState()

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
//        UploadPhotoView("Загрузите фотографию")
//        AddAddressView("Укажите адрес")
//        PetLocationView("Где вы видели питомца")
        PetDescriptionView(
            "Опишите питомца",
            lostPetType = lostPetType.value, //TODO используется для переключателя иконок
            lostPetHeader = lostPetHeader.value,
            lostPetDescription = lostPetDescription.value,
            viewModel::setAdPetType,
            viewModel::setAdHeader,
            viewModel::setAdDescription
        )
    }
}