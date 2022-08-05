package com.example.petproject.viewComponents.buttons

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.*
import com.example.petproject.statesEnum.PetIconButtonType

@Composable
fun PetButtonIconVertical(
    petIconButtonType: PetIconButtonType,
    callbackPetIconType: ( PetIconButtonType) -> Unit
) {
    val isChecked = remember{ mutableStateOf(false)}

    Button(
        onClick = {
            callbackPetIconType(petIconButtonType)
            isChecked.value = !isChecked.value
        },
        modifier = Modifier
            .size(96.dp),
        colors = when(isChecked.value){
            true -> {
                ButtonDefaults.buttonColors(backgroundColor = sand, contentColor = white)
            }
            else -> {
                ButtonDefaults.buttonColors(backgroundColor = mainBlue, contentColor = white)
            }
        },
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp, pressedElevation = 10.dp
        ),
        shape = smallShape,
        contentPadding = buttonIconContentPadding
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(petIconButtonType.iconId),
                contentDescription = petIconButtonType.iconDescription
            )
            Text(
                text = petIconButtonType.textButton,
                style = petTypeButtonTextStyle,
                textAlign = TextAlign.Center
            )
        }
    }
}

