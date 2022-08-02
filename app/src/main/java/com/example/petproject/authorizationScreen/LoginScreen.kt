package com.example.petproject.authorizationScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.petproject.R
import com.example.petproject.utils.AuthCheckCallback
import com.example.petproject.utils.TextFieldCallback
import com.example.petproject.viewComponents.buttons.MainButton
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
    callbackLoginValid: AuthCheckCallback,
    callbackClearFocus: () -> Unit
) {
    LoginForm(
        callbackEmail,
        callbackPassword,
        email,
        password,
        emailValid,
        passwordValid
    )
    MainButton(
        text = stringResource(R.string.login),
        imageResourceId = R.drawable.paw,
        imageDescriptionId = R.string.paw_icon_description,
        callbackLoginValid,
        callbackClearFocus
    )
    TransparentButton(
        text = stringResource(R.string.forgot_password)
    )
}
