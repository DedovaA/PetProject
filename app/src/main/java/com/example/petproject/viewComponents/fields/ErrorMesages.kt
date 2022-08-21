package com.example.petproject.viewComponents.fields

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.EMPTY_STRING
import com.example.petproject.consts.uiConsts.errorCaptionTextStyle

/**
 * Сообщения об ошибках ввода
 */

@Composable
fun EmptyFieldValidationMessage(isFieldValid: Boolean) {
    when (isFieldValid) {
        false -> ErrorMessage(message = stringResource(R.string.error_message_empty_field))
        true -> ErrorMessage(EMPTY_STRING)
    }
}

@Composable
fun EmailFormatValidationMessage(isEmailValid: Boolean, email: String) {
    when (isEmailValid) {
        false -> when (email) {
            EMPTY_STRING -> ErrorMessage(message = stringResource(R.string.error_message_empty_field))
            else -> ErrorMessage(message = stringResource(R.string.error_message_email))
        }
        true -> ErrorMessage(message = EMPTY_STRING)
    }
}

//TODO
@Composable
fun TextLengthValidationMessage(isLengthValid: Boolean, text: String) {
    when (isLengthValid) {
        false -> when (text) {
            EMPTY_STRING -> ErrorMessage(message = stringResource(R.string.error_message_empty_field))
            else -> ErrorMessage(message = "Превышено количество символов — «Максимум — 46 символов»")
        }
        true -> ErrorMessage(message = EMPTY_STRING)
    }
}

@Composable
fun ErrorMessage(message: String) {
    Text(
        text = message,
        style = errorCaptionTextStyle,
        modifier = Modifier.padding(bottom = 16.dp)
    )
}