package com.example.petproject.announcementScreen

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.mainBlue
import com.example.petproject.consts.uiConsts.topBarTextStyle

//@Preview
@Composable
fun TopBar(
    text: String
) {
    TopAppBar(
        modifier = Modifier.height(64.dp),
        contentColor = Color.White,
        backgroundColor = mainBlue,
        elevation = 2.dp
    ) {
        IconButton(
            modifier = Modifier.padding(horizontal = 8.dp),
            onClick = { /*TODO*/ }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.top_bar_back_icon),
                contentDescription = "back"
            )
        }
        Text(
            modifier = Modifier
                .width(280.dp)
                .padding(bottom = 4.dp),
            text = text,
            style = topBarTextStyle,
            maxLines = 2,
            textAlign = TextAlign.Center
        )
    }
}