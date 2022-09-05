package com.example.petproject.authScreen.subview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.EMPTY_STRING
import com.example.petproject.viewComponents.fields.EmailFormatValidationMessage
import com.example.petproject.viewComponents.fields.EmptyFieldValidationMessage
import com.example.petproject.viewComponents.fields.ErrorMessage
import com.example.petproject.utils.TextFieldCallback
import com.example.petproject.viewComponents.fields.Field
import com.example.petproject.viewComponents.fields.PasswordField

@Composable
fun RegisterForm(
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
    passwordConfValid: Boolean
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
                hint = stringResource(R.string.name),
                inputType = KeyboardType.Text,
                textValue = name,
                callbackField = callbackName,
                errorInput = nameValid
            )
            EmptyFieldValidationMessage(isFieldValid = nameValid)

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

            PasswordField(
                hint = stringResource(R.string.repeat_password),
                textValue = passwordConfirm,
                callbackPassword = callbackPasswordConfirm,
                errorInput = passwordConfValid
            )
            when (passwordConfValid) {
                false -> when (passwordConfirm) {
                    EMPTY_STRING -> ErrorMessage(message = stringResource(R.string.error_message_empty_field))
                    else -> ErrorMessage(message = stringResource(R.string.error_message_confirm_password))
                }
                true -> ErrorMessage(message = EMPTY_STRING)
            }
        }
    }
}
