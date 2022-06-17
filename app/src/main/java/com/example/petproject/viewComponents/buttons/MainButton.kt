package com.example.petproject.viewComponents.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.*

@Preview
@Composable
fun MainButton(
    text: String = "MainButton",
    imageResourceId: Int = R.drawable.paw,
    imageDescriptionId: Int = R.string.paw_icon_description
) {
    Button(
        onClick = { },
        modifier = Modifier.padding(top = 8.dp),
        colors = buttonColors(backgroundColor = mainBlue, contentColor = textWhite),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 10.dp,
        ),
        shape = smallShape,
        contentPadding = buttonContentPadding
    )
    {
        Icon(
            painter = painterResource(imageResourceId),
            contentDescription = stringResource(imageDescriptionId),
        )
        Spacer(Modifier.size(12.dp))
        Text(
            text = text,
            style = mainButtonTextStyle
        )
    }
}