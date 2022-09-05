package com.example.petproject.viewComponents.buttons

import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.buttonIconContentPadding
import com.example.petproject.consts.uiConsts.mainBlue
import com.example.petproject.consts.uiConsts.smallShape
import com.example.petproject.consts.uiConsts.white

@Composable
fun ButtonIcon(
       iconResourceId: Int,
       iconDescription: String,
       callbackOnClick: () -> Unit
) {
    Button(
        onClick = {
            callbackOnClick()
        },
        modifier = Modifier
            .size(56.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = mainBlue, contentColor = white
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp, pressedElevation = 10.dp
        ),
        shape = smallShape,
        contentPadding = buttonIconContentPadding
    ) {
        Icon(
            painter = painterResource(iconResourceId),
            contentDescription = iconDescription
        )
    }
}