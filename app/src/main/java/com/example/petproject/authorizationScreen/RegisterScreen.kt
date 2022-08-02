package com.example.petproject.authorizationScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.petproject.R
import com.example.petproject.utils.AuthCheckCallback
import com.example.petproject.utils.TextFieldCallback
import com.example.petproject.viewComponents.buttons.MainButton
import com.example.petproject.viewComponents.forms.RegisterForm

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
    callbackRegisterValid: AuthCheckCallback,
    callbackClearFocus: () -> Unit
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
    MainButton(
        text = stringResource(R.string.registration),
        imageResourceId = R.drawable.paw,
        imageDescriptionId = R.string.paw_icon_description,
        callbackLoginValid = callbackRegisterValid,
        callbackClearFocus
    )
}
