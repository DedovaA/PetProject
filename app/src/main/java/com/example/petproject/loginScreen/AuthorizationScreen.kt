package com.example.petproject.loginScreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.petproject.AuthViewModel
import com.example.petproject.R
import com.example.petproject.statesEnum.AuthFormType
import com.example.petproject.viewComponents.Logo
import com.example.petproject.viewComponents.buttons.LoginSwitchButtonGroup
import com.example.petproject.viewComponents.buttons.TransparentButtonWithIcon

@Composable
fun AuthorizationScreen(viewModel: AuthViewModel) {
    val authForm = viewModel.authFormType.observeAsState(AuthFormType.login)

    val name = viewModel.name.observeAsState("")
    val email = viewModel.email.observeAsState("")
    val password = viewModel.password.observeAsState("")
    val passwordConfirm = viewModel.passwordConfirm.observeAsState("")

    val nameValid = viewModel.nameIsValid.observeAsState(true)
    val emailValid = viewModel.emailIsValid.observeAsState(true)
    val passwordValid = viewModel.passwordIsValid.observeAsState(true)
    val passwordConfValid = viewModel.passwordConfirmIsValid.observeAsState(true)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Logo()
            LoginSwitchButtonGroup(
                isLogin = when (authForm.value) {
                    AuthFormType.login -> true
                    AuthFormType.registration -> false
                },
                callback = viewModel::switchAuthScreen
            )

            when (authForm.value) {
                AuthFormType.login -> LoginScreen(
                    callbackEmail = viewModel::setEmail,
                    callbackPassword = viewModel::setPassword,
                    email = email.value,
                    password = password.value,
                    emailValid = emailValid.value,
                    passwordValid = passwordValid.value,
                    callbackLoginValid = viewModel::loginValidation
                )
                AuthFormType.registration -> RegisterScreen(
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
                    callbackRegisterValid = viewModel::registerValidation
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
