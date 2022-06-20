package com.example.petproject.loginScreen

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.petproject.R
import com.example.petproject.viewComponents.buttons.MainButton
import com.example.petproject.viewComponents.forms.RegisterForm

@Preview(showBackground = true)
@Composable
fun RegisterScreen() {
    RegisterForm()
    MainButton(
        text = stringResource(R.string.registration),
        imageResourceId = R.drawable.paw,
        imageDescriptionId = R.string.paw_icon_description
    )
}

