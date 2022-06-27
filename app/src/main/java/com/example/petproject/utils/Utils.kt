package com.example.petproject.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.petproject.R
import com.example.petproject.viewComponents.forms.ErrorMessage

/**
 * Сообщения об ошибках ввода
 */

@Composable
fun EmptyFieldValidationMessage(isFieldValid:Boolean){
    when(isFieldValid){
        false -> ErrorMessage(stringResource(R.string.error_message_empty_field))
        true -> ErrorMessage(EMPTY_STRING)
    }
}

@Composable
fun EmailFormatValidationMessage(isEmailValid:Boolean, email:String){
    when(isEmailValid){
        false -> when(email){
            EMPTY_STRING -> ErrorMessage(stringResource(R.string.error_message_empty_field))
            else -> ErrorMessage(stringResource(R.string.error_message_email))
        }
        true -> ErrorMessage(EMPTY_STRING)
}

}