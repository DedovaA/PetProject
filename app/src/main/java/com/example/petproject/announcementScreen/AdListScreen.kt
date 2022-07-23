package com.example.petproject.announcementScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.petproject.AuthViewModel
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.*
import com.example.petproject.repo.AnnouncementList
import com.example.petproject.repo.DataAnnouncement
import com.example.petproject.repo.GeoPosition

@Preview
@Composable
fun AdListScreen(
    viewModel: AuthViewModel
) {
    val adList = viewModel.visibleAdList.observeAsState(
        listOf(
            DataAnnouncement(
                id = 1,
                petType = "dog",
                imageUrl = "https://i.pinimg.com/736x/c7/03/3e/c7033e28b42d5a4848e818379043944a.jpg",
                title = "Fat Doggo",
                description = "needs nothing",
                geoPosition = GeoPosition(73.37, 54.5)
            ),
            DataAnnouncement(
                id = 2,
                petType = "dog2",
                imageUrl = "https://i.pinimg.com/736x/c7/03/3e/c7033e28b42d5a4848e818379043944a.jpg",
                title = "Fat Doggo2",
                description = "needs nothing",
                geoPosition = GeoPosition(73.37, 54.5)
            ),
            DataAnnouncement(
                id = 3,
                petType = "dog3",
                imageUrl = "https://i.pinimg.com/736x/c7/03/3e/c7033e28b42d5a4848e818379043944a.jpg",
                title = "Fat Doggo3",
                description = "needs nothing",
                geoPosition = GeoPosition(73.37, 54.5)
            ),
            DataAnnouncement(
                id = 4,
                petType = "dog4",
                imageUrl = "https://i.pinimg.com/736x/c7/03/3e/c7033e28b42d5a4848e818379043944a.jpg",
                title = "Fat Doggo4",
                description = "needs nothing",
                geoPosition = GeoPosition(73.37, 54.5)
            )
        )
    )

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        itemsIndexed(
            adList.value as List<DataAnnouncement>
        ){
            _, item -> ItemView(dataAnnouncement = item)
        }
    }
}

@Preview
@Composable
fun ItemView(
    dataAnnouncement: DataAnnouncement
    /**
    imgId: Int = R.drawable.empty_pic,
    header: String = "Название...",
    desc: String = "Описание потерявшегося животного",
    locAddress: String = "ул. Партизана Железняка, 34/2"
    */
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
            AdPhoto(dataAnnouncement.imageUrl)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp, start = 10.dp, end = 10.dp),
            ) {
                AdHeader(dataAnnouncement.title)
                AdDescription(dataAnnouncement.description)
                AdLocation("ул. Партизана Железняка, 34/2")
            }

        }
    }
}

@Preview
@Composable
fun AdPhoto(imageUrl: String) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
    ) {
//        Image(
//            painter = painterResource(imgId),
//            contentDescription = "pets photo",
//            modifier = Modifier.size(168.dp),
//            contentScale = ContentScale.Crop
//        )
        AsyncImage(
            model = imageUrl,
            contentDescription = "pets photo",
            modifier = Modifier.size(168.dp),
            contentScale = ContentScale.Fit
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