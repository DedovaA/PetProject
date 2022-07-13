package com.example.petproject.loginScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.petproject.R
import com.example.petproject.viewComponents.buttons.MainButton
import com.example.petproject.viewComponents.forms.RegisterForm

//@Preview(showBackground = true)
@Composable
fun RegisterScreen(
    callbackName: TextFieldCallback,
    callbackEmail: TextFieldCallback,
    callbackPassword: TextFieldCallback,
    callbackPasswordConfirm: TextFieldCallback,
    name:String,
    email:String,
    password: String,
    passwordConfirm:String,
    nameValid: Boolean,
    emailValid: Boolean,
    passwordValid: Boolean,
    passwordConfValid: Boolean,
    callbackRegisterValid: AuthCheckCallback,
    callbackHealthcheck: () -> Unit
) {
    RegisterForm(
        callbackName,
        callbackEmail,
        callbackPassword,
        callbackPasswordConfirm,
        name,
        email,
        password,
        passwordConfirm,
        nameValid,
        emailValid,
        passwordValid,
        passwordConfValid
    )
    MainButton(
        text = stringResource(R.string.registration),
        imageResourceId = R.drawable.paw,
        imageDescriptionId = R.string.paw_icon_description,
        callbackRegisterValid,
        callbackHealthcheck
    )
}

