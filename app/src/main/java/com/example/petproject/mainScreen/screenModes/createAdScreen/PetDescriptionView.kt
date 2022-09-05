package com.example.petproject.mainScreen.screenModes.createAdScreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.mainScreen.TopBar
import com.example.petproject.mainScreen.screenModes.createAdScreen.subview.FieldPetDescription
import com.example.petproject.statesEnum.PetIconButtonType
import com.example.petproject.statesEnum.PetType
import com.example.petproject.viewComponents.buttons.MainButtonWithStarIcon
import com.example.petproject.viewComponents.buttons.PetButtonIconVertical
import com.example.petproject.viewComponents.fields.EmptyFieldValidationMessage
import com.example.petproject.viewComponents.fields.Field
import com.example.petproject.viewComponents.fields.TextLengthValidationMessage

@Composable
fun PetDescriptionView(
    topBarText: String,
    lostPetType: PetType,
    lostPetHeader: String,
    lostPetDescription: String,
    callbackType: (PetType)-> Unit,
    callbackHeader: (String)-> Unit,
    callbackDescription: (String)-> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        TopBar(text = topBarText)
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    PetButtonIconVertical(lostPetType, petIconButtonType = PetIconButtonType.CatTypeIconButton, callbackPetType =  callbackType)
                    PetButtonIconVertical(lostPetType, petIconButtonType = PetIconButtonType.DogTypeIconButton, callbackPetType =  callbackType)
                    PetButtonIconVertical(lostPetType, petIconButtonType = PetIconButtonType.BunnyTypeIconButton, callbackPetType =  callbackType)
                }
                Spacer(modifier = Modifier.height(32.dp))
                Field(hint = "Название объявления", textValue = lostPetHeader, callbackField = callbackHeader, errorInput = true)
                TextLengthValidationMessage(isLengthValid = false, text = "")
                FieldPetDescription(hint = "Описание питомца", textValue = lostPetDescription, callbackField = callbackDescription, errorInput = true)
                EmptyFieldValidationMessage(isFieldValid = false)
            }
            Spacer(modifier = Modifier.height(16.dp))
            MainButtonWithStarIcon(
                textButton = "Разместить объявление",
                iconResourceId = R.drawable.check_icon,
                iconDescription = "check location",
                callbackOnClick = { }
            )
        }
    }
}