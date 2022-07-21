package com.example.petproject.announcementScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.*

@Preview
@Composable
fun AdListScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 32.dp, end = 32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceAround
    ) {
        NoAdsScreen()
    }
}

@Preview
@Composable
fun ItemView(
    imgId: Int = R.drawable.empty_pic,
    header: String = "Название...",
    desc: String = "Описание потерявшегося животного",
    locAddress: String = "ул. Партизана Железняка, 34/2"
) {
    Card(
        modifier = Modifier
            .size(height = 283.dp, width = 168.dp),
        shape = RoundedCornerShape(8.dp),
        elevation = 1.dp
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AdPhoto(imgId)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 10.dp, end = 10.dp),
            ) {
                AdHeader(header)
                AdDescription(desc)
                AdLocation(locAddress)
            }
        }
    }
}

@Preview
@Composable
fun AdPhoto(imgId: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(imgId),
            contentDescription = "pets photo",
            modifier = Modifier.size(168.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Preview
@Composable
fun AdHeader(header: String) {
    Text(
        text = header,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
        style = loginSwitchButtonTextStyle,
        maxLines = 1
    )
}

@Preview
@Composable
fun AdDescription(desc: String) {
    Text(
        text = desc,
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp),
//        textAlign = TextAlign.Start,
        style = adDescriptionTextStyle,
        maxLines = 2
    )
}

@Preview
@Composable
fun AdLocation(locAddress: String) {
    Box(
        modifier = Modifier.fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.paw_location_icon_24),
                contentDescription = "location icon",
                modifier = Modifier.padding(end = 4.dp)
            )
            Text(
                text = locAddress,
                modifier = Modifier.fillMaxWidth(),
                style = adLocationTextStyle,
                maxLines = 2
            )
        }
    }
}

@Preview
@Composable
fun NoAdsScreen() {
    Text(
        text = stringResource(R.string.no_ads_yet),
        color = validationGray,
        style = authFieldTextStyle
    )
}