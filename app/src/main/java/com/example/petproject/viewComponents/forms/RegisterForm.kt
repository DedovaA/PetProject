package com.example.petproject.viewComponents.forms

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject.R

@Preview
@Composable
fun RegisterForm() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 40.dp, bottom = 8.dp)
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Field(stringResource(R.string.name), KeyboardType.Text)
            ErrorMessage(stringResource(R.string.error_message_empty_field))
            Field(stringResource(R.string.email), KeyboardType.Email)
            ErrorMessage(stringResource(R.string.error_message_email))
            PasswordField(stringResource(R.string.password))
            ErrorMessage(stringResource(R.string.error_message_empty_field))
            PasswordField(stringResource(R.string.repeat_password))
            ErrorMessage(stringResource(R.string.error_message_confirm_password))
        }
    }
}


