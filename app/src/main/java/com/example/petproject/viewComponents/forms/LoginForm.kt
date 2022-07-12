package com.example.petproject.viewComponents.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.utils.TextFieldCallback
import com.example.petproject.utils.EmailFormatValidationMessage
import com.example.petproject.utils.EmptyFieldValidationMessage

// @Preview
@Composable
fun LoginForm(
    callbackEmail: TextFieldCallback,
    callbackPassword: TextFieldCallback,
    email: String,
    password: String,
    emailValid: Boolean,
    passwordValid: Boolean
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, bottom = 8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Field(
                hint = stringResource(R.string.email),
                inputType = KeyboardType.Email,
                textValue = email,
                callbackField = callbackEmail,
                errorInput = emailValid
            )
            EmailFormatValidationMessage(isEmailValid = emailValid, email = email)

            PasswordField(
                hint = stringResource(R.string.password),
                textValue = password,
                callbackPassword = callbackPassword,
                errorInput = passwordValid
            )
            EmptyFieldValidationMessage(isFieldValid = passwordValid)
        }
    }
}
