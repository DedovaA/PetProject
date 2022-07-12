package com.example.petproject.viewComponents.buttons

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.buttonContentPadding
import com.example.petproject.consts.uiConsts.transparentButtonTextStyle
import com.example.petproject.consts.uiConsts.validationBlack

@Composable
fun TransparentButtonWithIcon(
    text: String,
    imageResourceId: Int = R.drawable.arrow_back_ios,
    imageDescriptionId: Int = R.string.arrow_icon_description
) {
    TextButton(
        onClick = { },
        colors = buttonColors(
            backgroundColor = Color.Transparent, contentColor = validationBlack
        ),
        contentPadding = buttonContentPadding
    ) {
        Text(
            text = text, style = transparentButtonTextStyle
        )
        Spacer(Modifier.size(8.dp))
        Icon(
            painter = painterResource(imageResourceId),
            contentDescription = stringResource(imageDescriptionId)
        )
    }
}
