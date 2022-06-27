package com.example.petproject.viewComponents.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.loginScreen.TextFieldCallback
import com.example.petproject.utils.EmailFormatValidationMessage
import com.example.petproject.utils.EmptyFieldValidationMessage

//@Preview
@Composable
fun LoginForm(
    callbackEmail: TextFieldCallback,
    callbackPassword: TextFieldCallback,
    email:String,
    password:String,
    emailValid: Boolean,
    passwordValid: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, bottom = 8.dp)
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Field(
                stringResource(R.string.email),
                KeyboardType.Email,
                email,
                callbackEmail,
                emailValid
            )
            EmailFormatValidationMessage(emailValid, email)

            PasswordField(
                stringResource(R.string.password),
                password,
                callbackPassword,
                passwordValid
            )
            EmptyFieldValidationMessage(passwordValid)
        }
    }
}
