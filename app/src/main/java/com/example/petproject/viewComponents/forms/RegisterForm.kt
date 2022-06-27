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
import com.example.petproject.loginScreen.TextFieldCallback
import com.example.petproject.utils.EMPTY_STRING
import com.example.petproject.utils.emailFormatValidationMessage
import com.example.petproject.utils.emptyFieldValidationMessage

//@Preview
@Composable
fun RegisterForm(
    callbackName: TextFieldCallback,
    callbackEmail: TextFieldCallback,
    callbackPassword: TextFieldCallback,
    callbackPasswordConfirm: TextFieldCallback,
    name:String,
    email:String,
    password:String,
    passwordConfirm:String,
    nameValid: Boolean,
    emailValid: Boolean,
    passwordValid: Boolean,
    passwordConfValid: Boolean
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
                stringResource(R.string.name),
                KeyboardType.Text,
                name,
                callbackName,
                nameValid
            )
            emptyFieldValidationMessage(nameValid)

            Field(
                stringResource(R.string.email),
                KeyboardType.Email,
                email,
                callbackEmail,
                emailValid
            )
            emailFormatValidationMessage(emailValid,email)

            PasswordField(
                stringResource(R.string.password),
                password,
                callbackPassword,
                passwordValid
            )
            emptyFieldValidationMessage(passwordValid)

            PasswordField(
                stringResource(R.string.repeat_password),
                passwordConfirm,
                callbackPasswordConfirm,
                passwordConfValid
            )
                when (passwordConfValid) {
                    false-> when(passwordConfirm){
                        EMPTY_STRING -> ErrorMessage(stringResource(R.string.error_message_empty_field))
                        else -> ErrorMessage(stringResource(R.string.error_message_confirm_password))
                    }
                    true -> ErrorMessage(EMPTY_STRING)
                }
        }
    }
}


