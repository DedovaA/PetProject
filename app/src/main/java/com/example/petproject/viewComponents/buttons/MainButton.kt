package com.example.petproject.viewComponents.buttons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.*
import com.example.petproject.utils.AuthCheckCallback

@Composable
fun MainButton(
    text: String,
    imageResourceId: Int = R.drawable.paw,
    imageDescriptionId: Int = R.string.paw_icon_description,
    callbackLoginValid: AuthCheckCallback,
) {
    Button(
        onClick = {
            callbackLoginValid()
        },
        modifier = Modifier.padding(top = 8.dp),
        colors = buttonColors(
            backgroundColor = mainBlue, contentColor = textWhite
        ),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp, pressedElevation = 10.dp
        ),
        shape = smallShape,
        contentPadding = buttonContentPadding
    ) {
        Icon(
            painter = painterResource(imageResourceId),
            contentDescription = stringResource(imageDescriptionId),
        )
        Spacer(modifier = Modifier.size(12.dp))
        Text(
            text = text, style = mainButtonTextStyle
        )
    }
}
