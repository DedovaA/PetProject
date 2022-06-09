package com.example.petproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petproject.consts.uiConsts.mainBlue
import com.example.petproject.consts.uiConsts.neutrals_gray

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                ShowLoginScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowLoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Logo()
        LoginSwitchButtonGroup()
        RegistrationForm(
            fields = listOf(
                stringResource(R.string.name),
                stringResource(R.string.email),
                stringResource(R.string.password),
                stringResource(R.string.repeat_password)
            )
        )
        MainButton(text = stringResource(R.string.registration))
        LaterButton(stringResource(R.string.login_later))
    }
}

@Composable
private fun Logo() {
    BoxWithConstraints {
        val width = maxWidth
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = stringResource(R.string.logo_description),
            modifier = Modifier
                .width(width.times(0.452f))
        )
    }
}

@Composable
private fun LoginSwitchButtonGroup() {
    Row(
        modifier = Modifier.fillMaxWidth(),
    )
    {
        Box(
            Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        )
        {
            LoginSwitchButton(stringResource(R.string.enter_switch_btn))
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
        contentPadding = PaddingValues(vertical = 12.dp),
    )
    {
        Text(
            text = text,
            Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = Color.Black,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.mulish_bold))
            )
        )
    }
}

@Composable
private fun RegistrationForm(fields: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(32.dp)
    )
    {
        for (i in fields) {
            AuthorFormField(i)
        }
    }
}

@Composable
private fun AuthorFormField(hint: String) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    Card(
        modifier = Modifier.fillMaxWidth(),
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
                .fillMaxWidth()
        )
    }


//    var text by rememberSaveable { mutableStateOf("") }
//    Card(
//        modifier = Modifier.fillMaxWidth(),
//        shape = RoundedCornerShape(10.dp),
//        elevation = 15.dp
//    ) {
//        BasicTextField(
//            value = text,
//            onValueChange = {
//
//            },
//            textStyle = TextStyle(
//                color = neutrals_gray,
//                fontFamily = FontFamily(Font(R.font.mulish_regular)),
//                fontSize = 16.sp
//            ),
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(16.dp)
//        )
//    }

}

@Composable
private fun MainButton(text: String) {
    Button(
        border = BorderStroke(0.dp, Color.Transparent),
        onClick = { },
        shape = RoundedCornerShape(8.dp),
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 20.dp),
        elevation =  ButtonDefaults.elevation(
            defaultElevation = 6.dp,
            pressedElevation = 12.dp,
        ),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = mainBlue
        )
    )
    {
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

@Composable
private fun LaterButton(text: String) {
    TextButton(
        onClick = { },
        contentPadding = PaddingValues(horizontal = 32.dp, vertical = 20.dp),
    )
    {
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
            modifier = Modifier.padding(start = 12.dp),
            alignment = Alignment.Center
        )
    }
}






