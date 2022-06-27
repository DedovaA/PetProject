package com.example.petproject.viewComponents.buttons

import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.petproject.statesEnum.AuthFormType
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.loginSwitchButtonTextStyle
import com.example.petproject.consts.uiConsts.mainBlue
import com.example.petproject.consts.uiConsts.validationBlack
import com.example.petproject.loginScreen.AuthTypeCallback

@Composable
fun LoginSwitchButtonGroup(
    isLogin: Boolean = true,
    callback: AuthTypeCallback
) {
    var firstUnderLine: Dp = 1.dp
    var secondUnderLine: Dp = 1.dp

    when {
        isLogin -> firstUnderLine = 5.dp
        else -> secondUnderLine = 5.dp
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp)
    )
    {
        Box(
            Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        )
        {
            LoginSwitchButton(stringResource(R.string.login_switch_btn),
                AuthFormType.login, callback)
            Divider(color = mainBlue, thickness = firstUnderLine)
        }
        Box(
            Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        )
        {
            LoginSwitchButton(stringResource(R.string.registry_switch_btn), AuthFormType.registration, callback)
            Divider(color = mainBlue, thickness = secondUnderLine)
        }
    }
}

@Composable
fun LoginSwitchButton(
    text: String,
    type: AuthFormType,
    callback: (AuthFormType) -> Unit
) {
    TextButton(
        onClick = { callback(type) },
        modifier = Modifier.fillMaxWidth(),
        colors = buttonColors(backgroundColor = Color.Transparent, contentColor = validationBlack),
        contentPadding = PaddingValues.Absolute(top = 0.dp, bottom = 0.dp)
    ) {
        Text(
            text = text,
            Modifier.padding(vertical = 12.dp),
            style = loginSwitchButtonTextStyle,
            textAlign = TextAlign.Center
        )
    }
}
