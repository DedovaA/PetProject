package com.example.petproject.viewComponents.buttons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.*

//@Preview
@Composable
fun MainButtonWithEndIcon(
    textButton: String,
    iconResourceId: Int,
    iconDescription: String,
    callbackOnClick: () -> Unit
) {
    Button(
        onClick = {
        },
        modifier = Modifier
            .padding(top = 8.dp)
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = mainBlue, contentColor = white
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp, pressedElevation = 10.dp
        ),
        shape = smallShape,
        contentPadding = buttonContentPadding
    ) {
        Text(
            text = textButton, style = mainButtonTextStyle
        )
        Spacer(modifier = Modifier.size(12.dp))
        Icon(
            painter = painterResource(iconResourceId),
            contentDescription = iconDescription,
        )
    }
}
