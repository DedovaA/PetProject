package com.example.petproject.announcementScreen.modes.showAd

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.petproject.R
import com.example.petproject.announcementScreen.TopBar
import com.example.petproject.consts.uiConsts.adLocationTextStyle
import com.example.petproject.consts.uiConsts.neutralsDeepGray
import com.example.petproject.consts.uiConsts.petCardBackground
import com.example.petproject.repo.DataAnnouncement
import com.example.petproject.viewComponents.buttons.MainButton

//@Preview
@Composable
fun ShowAd(
    textTopBar: String = "Заголовок объявления на двух строках",
    dataAnnouncement: DataAnnouncement
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar(textTopBar)
        }
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            BoxWithConstraints(
                modifier = Modifier.background(color = petCardBackground)
            ){
                val with = maxHeight
                AsyncImage(
                    modifier = Modifier.size(with),
                    model = dataAnnouncement.imageUrl,
                    contentDescription = "pets photo",
                    contentScale = ContentScale.Fit
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .padding(horizontal = 16.dp, vertical = 24.dp),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Image(
                    painter = painterResource(id = R.drawable.paw_on_show_ad_location_icon),
                    contentDescription = "ad location icon",
                    modifier = Modifier.padding(end = 10.dp)
                )
                Text(
                    text = "ул. Мира, 91",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 10.dp),
                    style = adLocationTextStyle,
                    color = neutralsDeepGray,
                    maxLines = 2
                )
                MainButton(
                    text = "На карте",
                    callback = { /*TODO*/ }
                )
            }
        }
    }
}