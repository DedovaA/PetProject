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
            Field(stringResource(R.string.name), KeyboardType.Text, name, callbackName, nameValid)
            when(nameValid){
                false -> ErrorMessage(stringResource(R.string.error_message_empty_field))
                else -> ErrorMessage(stringResource(R.string.empty_string))
            }

            Field(stringResource(R.string.email), KeyboardType.Email, email, callbackEmail, emailValid)
            when(emailValid){
                false -> when(email){
                    "" -> ErrorMessage(stringResource(R.string.error_message_empty_field))
                    else -> ErrorMessage(stringResource(R.string.error_message_email))
                }
                else -> ErrorMessage(stringResource(R.string.empty_string))
            }
            PasswordField(stringResource(R.string.password),password, callbackPassword, passwordValid)
            when (passwordValid) {
                false-> ErrorMessage(stringResource(R.string.error_message_empty_field))
                else -> ErrorMessage(stringResource(R.string.empty_string))
            }
            PasswordField(stringResource(R.string.repeat_password),passwordConfirm, callbackPasswordConfirm, passwordConfValid)
            when (passwordConfValid) {
                false-> when(passwordConfirm){
                    "" -> ErrorMessage(stringResource(R.string.error_message_empty_field))
                    else -> ErrorMessage(stringResource(R.string.error_message_confirm_password))
                }
                else -> ErrorMessage(stringResource(R.string.empty_string))
            }
        }
    }
}


