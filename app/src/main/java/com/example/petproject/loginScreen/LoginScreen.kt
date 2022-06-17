package com.example.petproject.loginScreen

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.viewComponents.Logo
import com.example.petproject.viewComponents.buttons.LoginSwitchButtonGroup
import com.example.petproject.viewComponents.buttons.MainButton
import com.example.petproject.viewComponents.buttons.TransparentButton
import com.example.petproject.viewComponents.buttons.TransparentButtonWithIcon
import com.example.petproject.viewComponents.forms.LoginForm

@Preview(showBackground = true)
@Composable
fun LoginScreen() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(start = 32.dp, end = 32.dp),
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.SpaceBetween
//    ) {
//        Column(
//            modifier = Modifier.fillMaxWidth(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//            verticalArrangement = Arrangement.SpaceBetween
//        )
//            {
//                Logo()
//                LoginSwitchButtonGroup(true)
                LoginForm()
                MainButton(
                    text = stringResource(R.string.login),
                    imageResourceId = R.drawable.paw,
                    imageDescriptionId = R.string.paw_icon_description
                )
                TransparentButton(
                    text = stringResource(R.string.forgot_password)
                )
//            }
//
//        TransparentButtonWithIcon(
//            text = stringResource(R.string.login_later),
//            imageResourceId = R.drawable.arrow_back_ios,
//            imageDescriptionId = R.string.arrow_icon_description
//        )
//    }
}
