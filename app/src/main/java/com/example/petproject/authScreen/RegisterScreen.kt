package com.example.petproject.authScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.petproject.R
import com.example.petproject.utils.AuthCheckCallback
import com.example.petproject.utils.TextFieldCallback
import com.example.petproject.viewComponents.buttons.MainButtonWithStarIcon
import com.example.petproject.authScreen.subview.RegisterForm

@Composable
fun RegisterScreen(
    callbackName: TextFieldCallback,
    callbackEmail: TextFieldCallback,
    callbackPassword: TextFieldCallback,
    callbackPasswordConfirm: TextFieldCallback,
    name: String,
    email: String,
    password: String,
    passwordConfirm: String,
    nameValid: Boolean,
    emailValid: Boolean,
    passwordValid: Boolean,
    passwordConfValid: Boolean,
    callbackOnClick: AuthCheckCallback
) {
    RegisterForm(
        callbackName = callbackName,
        callbackEmail = callbackEmail,
        callbackPassword = callbackPassword,
        callbackPasswordConfirm = callbackPasswordConfirm,
        name = name,
        email = email,
        password = password,
        passwordConfirm = passwordConfirm,
        nameValid = nameValid,
        emailValid = emailValid,
        passwordValid = passwordValid,
        passwordConfValid = passwordConfValid
    )
    MainButtonWithStarIcon(
        textButton = stringResource(R.string.registration),
        iconResourceId = R.drawable.paw,
        iconDescription = stringResource(id = R.string.paw_icon_description),
        callbackOnClick = callbackOnClick
    )
}
