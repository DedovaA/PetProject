package com.example.petproject.loginScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.petproject.R
import com.example.petproject.viewComponents.buttons.MainButton
import com.example.petproject.viewComponents.buttons.TransparentButton
import com.example.petproject.viewComponents.forms.LoginForm

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
    LoginForm()
    MainButton(
        text = stringResource(R.string.login),
        imageResourceId = R.drawable.paw,
        imageDescriptionId = R.string.paw_icon_description
    )
    TransparentButton(
        text = stringResource(R.string.forgot_password)
    )
}
