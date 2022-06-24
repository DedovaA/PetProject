package com.example.petproject.viewComponents.forms

import android.util.Log
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

//@Preview
@Composable
fun LoginForm(callbackEmail: TextFieldCallback,
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
            Field(stringResource(R.string.email), KeyboardType.Email, email, callbackEmail, emailValid)
            when(emailValid){
                false -> when(email){
                    "" -> ErrorMessage(stringResource(R.string.error_message_empty_field))
                    else -> ErrorMessage(stringResource(R.string.error_message_email))
                }
                else -> ErrorMessage(stringResource(R.string.empty_string))
            }

            PasswordField(stringResource(R.string.password), password, callbackPassword, passwordValid)
            when (passwordValid) {
                false-> ErrorMessage(stringResource(R.string.error_message_empty_field))
                else -> ErrorMessage(stringResource(R.string.empty_string))
            }
        }
    }
}
