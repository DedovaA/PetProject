package com.example.petproject.consts.uiConsts

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petproject.R

@Preview(showBackground = true)
@Composable
fun ShowRegisterScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp),
//            .background(Color.Yellow),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
//                .padding(top = 40.dp),
//                .background(Color.Red),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        )
            {
                Logo()
                LoginSwitchButtonGroup()
                RegisterForm(
                    fields = listOf(
                        stringResource(R.string.name),
                        stringResource(R.string.email),
                        stringResource(R.string.password),
                        stringResource(R.string.repeat_password)
                    )
                )
                MainButton(text = stringResource(R.string.registration))
            }
        LaterButton(stringResource(R.string.login_later))
    }
}

@Composable
private fun Logo() {
    Image(
        painter = painterResource(id = R.drawable.logo),
        contentDescription = stringResource(R.string.logo_description),
        modifier = Modifier
            .padding(top = 40.dp)
    )

//    BoxWithConstraints {
//        val width = maxWidth
//        Image(
//            painter = painterResource(id = R.drawable.logo),
//            contentDescription = stringResource(R.string.logo_description),
//            modifier = Modifier
//                .width(width.times(0.452f))
//                .padding(top = 40.dp)
//        )
//    }
}

@Composable
private fun LoginSwitchButtonGroup() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 32.dp),
//            .background(Color.Magenta),
    )
    {
        Box(
            Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        )
        {
            LoginSwitchButton(stringResource(R.string.login_switch_btn))
            Divider(color = mainBlue, thickness = 1.dp)
        }
        Box(
            Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        )
        {
            LoginSwitchButton(stringResource(R.string.registry_switch_btn))
            Divider(color = mainBlue, thickness = 5.dp)
        }
    }
}

@Composable
private fun LoginSwitchButton(text: String) {
    TextButton(
        onClick = { },
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(vertical = 0.dp)
    )
    {
        Text(
            text = text,
            Modifier
                .padding(vertical = 12.dp),
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.mulish_bold)),
                textAlign = TextAlign.Center
            )
        )
    }
}

@Composable
private fun RegisterForm(fields: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
//            .heightIn(min = 320.dp)
            .padding(top = 40.dp, bottom = 8.dp),
//            .background(Color.Green),
    )
    {

        for (i in fields) {
            val keyboardType = when (i) {
                stringResource(R.string.name) -> KeyboardType.Text
                stringResource(R.string.email) -> KeyboardType.Email
                stringResource(R.string.password) -> KeyboardType.Password
                stringResource(R.string.repeat_password) -> KeyboardType.Password
                else -> {
                    KeyboardType.Text
                }
            }
            RegisterField(i, keyboardType)
        }
    }
}

@Composable
private fun RegisterField(hint: String, inputType: KeyboardType) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Column(
        modifier = Modifier
            .fillMaxWidth()
    )
    {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = 10.dp
        ) {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    textStyle = TextStyle(
                        color = neutrals_gray,
                        fontFamily = FontFamily(Font(R.font.mulish_regular)),
                        fontSize = 16.sp
                    ),
                    placeholder = { Text(text = hint) },
                    modifier = Modifier
                        .fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = inputType),
//                    visualTransformation = PasswordVisualTransformation()
                )
        }
        Text(
            text = "Неверный формат email. Пример: name@gmail.com",
            color = Color.Red,
            fontFamily = FontFamily(Font(R.font.mulish_regular)),
            fontSize = 12.sp,
            modifier = Modifier
                .padding(bottom = 16.dp),
        )
    }
}

@Composable
private fun MainButton(text: String) {
    Button(
        modifier = Modifier
            .padding(top = 8.dp),
//        border = BorderStroke(0.dp, Color.Transparent),
        onClick = { },
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(0.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 10.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = mainBlue
        )
    )
    {
        Row(
            modifier = Modifier
                .padding(horizontal = 32.dp, vertical = 18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.paw),
                contentDescription = stringResource(R.string.paw_icon_description),
                modifier = Modifier.padding(end = 12.dp)
            )
            Text(
                text = text,
                style = TextStyle(
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.mulish_bold)),
                    fontSize = 16.sp
                )
            )
        }

    }
}

@Composable
private fun LaterButton(text: String) {
    TextButton(
        onClick = { },
//        modifier = Modifier
//            .padding(bottom = 32.dp),
        contentPadding = PaddingValues(0.dp)
        )
    {
        Row(
            modifier = Modifier.padding(horizontal = 32.dp, vertical = 18.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text,
                style = TextStyle(
                    color = Color.Black,
                    fontFamily = FontFamily(Font(R.font.mulish_semi_bold)),
                    fontSize = 16.sp
                )
            )
            Image(
                painter = painterResource(id = R.drawable.arrow_back_ios),
                contentDescription = stringResource(R.string.arrow_icon_description),
                modifier = Modifier
                    .padding(start = 8.dp)
            )
        }
    }
}