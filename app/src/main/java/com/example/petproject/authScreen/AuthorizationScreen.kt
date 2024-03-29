package com.example.petproject.authScreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.statesEnum.AuthFormType
import com.example.petproject.viewComponents.buttons.LoginSwitchButtonGroup
import com.example.petproject.viewComponents.buttons.TransparentButtonWithIcon
import com.example.petproject.viewComponents.logos.Logo

@Composable
fun AuthorizationScreen(viewModel: AuthViewModel) {
    val authForm = viewModel.authFormType.observeAsState(AuthFormType.Login)

    val name = viewModel.name.observeAsState("")
    val email = viewModel.email.observeAsState("")
    val password = viewModel.password.observeAsState("")
    val passwordConfirm = viewModel.passwordConfirm.observeAsState("")

    val nameValid = viewModel.nameIsValid.observeAsState(true)
    val emailValid = viewModel.emailIsValid.observeAsState(true)
    val passwordValid = viewModel.passwordIsValid.observeAsState(true)
    val passwordConfValid = viewModel.passwordConfirmIsValid.observeAsState(true)

    val fieldFocus = viewModel.focusEnable.observeAsState(true)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {

        val focusRequester = remember { FocusRequester() }
        val focusManager = LocalFocusManager.current
        if(!fieldFocus.value)focusManager.clearFocus()

        Column(
            modifier = Modifier.fillMaxWidth().focusRequester(focusRequester),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Logo()
            LoginSwitchButtonGroup(
                isLogin = when (authForm.value) {
                    AuthFormType.Login -> true
                    AuthFormType.Registration -> false
                },
                callback = viewModel::switchAuthScreen
            )

            when (authForm.value) {
                AuthFormType.Login -> LoginScreen(
                    callbackEmail = viewModel::setEmail,
                    callbackPassword = viewModel::setPassword,
                    email = email.value,
                    password = password.value,
                    emailValid = emailValid.value,
                    passwordValid = passwordValid.value,
                    callbackOnClick = viewModel::loginValidation
                )
                AuthFormType.Registration -> RegisterScreen(
                    callbackName = viewModel::setName,
                    callbackEmail = viewModel::setEmail,
                    callbackPassword = viewModel::setPassword,
                    callbackPasswordConfirm = viewModel::setPasswordConfirm,
                    name = name.value,
                    email = email.value,
                    password = password.value,
                    passwordConfirm = passwordConfirm.value,
                    nameValid = nameValid.value,
                    emailValid = emailValid.value,
                    passwordValid = passwordValid.value,
                    passwordConfValid = passwordConfValid.value,
                    callbackOnClick = viewModel::registerValidation
                )
            }
        }
        TransparentButtonWithIcon(
            text = stringResource(R.string.login_later),
            imageResourceId = R.drawable.arrow_back_ios,
            imageDescriptionId = R.string.arrow_icon_description,
            callbackProceedWithoutLogin = viewModel::proceedWithoutLogin
        )
    }
}
