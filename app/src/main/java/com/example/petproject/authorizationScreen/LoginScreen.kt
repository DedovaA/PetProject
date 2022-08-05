package com.example.petproject.authorizationScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.petproject.R
import com.example.petproject.utils.AuthCheckCallback
import com.example.petproject.utils.TextFieldCallback
import com.example.petproject.viewComponents.buttons.MainButtonWithStarIcon
import com.example.petproject.viewComponents.buttons.TransparentButton
import com.example.petproject.viewComponents.forms.LoginForm

@Composable
fun LoginScreen(
    callbackEmail: TextFieldCallback,
    callbackPassword: TextFieldCallback,
    email: String,
    password: String,
    emailValid: Boolean,
    passwordValid: Boolean,
    callbackOnClick: AuthCheckCallback
) {
    LoginForm(
        callbackEmail,
        callbackPassword,
        email,
        password,
        emailValid,
        passwordValid
    )
    MainButtonWithStarIcon(
        textButton = stringResource(R.string.login),
        iconResourceId = R.drawable.paw,
        iconDescription = stringResource(id = R.string.paw_icon_description),
        callbackOnClick = callbackOnClick
    )
    TransparentButton(
        text = stringResource(R.string.forgot_password)
    )
}
