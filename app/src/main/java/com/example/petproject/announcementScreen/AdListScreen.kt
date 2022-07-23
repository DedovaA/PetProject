package com.example.petproject.announcementScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.petproject.AuthViewModel
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.*
import com.example.petproject.repo.AnnouncementList
import com.example.petproject.repo.DataAnnouncement
import com.example.petproject.repo.GeoPosition
import com.example.petproject.statesEnum.AuthFormType
import com.example.petproject.statesEnum.PetType
import com.example.petproject.ui.theme.Shapes
import com.example.petproject.viewComponents.buttons.LoginSwitchButton

@OptIn(ExperimentalFoundationApi::class)
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

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        PetTypeSwitchButtonGroup()
        LazyVerticalGrid(
            cells = GridCells.Fixed(2),
            Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(
                8.dp,
                alignment = Alignment.CenterHorizontally
            ),
            content = {
                items((adList.value as List<DataAnnouncement>).size){
                        i -> PetCard((adList.value as List<DataAnnouncement>)[i])
                }
            }
        )
    }


//    LazyColumn(
//        modifier = Modifier.fillMaxSize(),
//        horizontalAlignment = Alignment.CenterHorizontally
//    ){
//        itemsIndexed(
//            adList.value as List<DataAnnouncement>
//        ){
//            _, item -> PetCard(dataAnnouncement = item)
//        }
//    }
}

@Preview
@Composable
fun PetCard(dataAnnouncement: DataAnnouncement){
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
            .fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
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

@Preview
@Composable
fun PetTypeButton(
    text: String,
    type: PetType,
//    callback: (PetType) -> Unit
) {
    TextButton(
        onClick = {  },
        modifier = Modifier
            .fillMaxWidth()
            .background(mainBlue),
        shape = RectangleShape
    ) {
        Text(
            text = text,
            modifier = Modifier.padding(vertical = 16.dp),
            style = petTypeButtonTextStyle,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun PetTypeSwitchButtonGroup(
    petType: PetType = PetType.all,
//    callback: (PetType) -> Unit
) {
    var allUnderlined: Dp = 1.dp
    var dogsUnderlined: Dp = 1.dp
    var catsUnderlined: Dp = 1.dp
    var otherUnderlined: Dp = 1.dp

    when (petType){
        PetType.dogs -> dogsUnderlined = 5.dp
        PetType.cats -> catsUnderlined = 5.dp
        PetType.other -> otherUnderlined = 5.dp
        else -> allUnderlined = 5.dp
    }

    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        ) {
            PetTypeButton(
                text = "Все",
                type = PetType.all,
//                callback = callback
            )
            Divider(color = textWhite, thickness = allUnderlined)
        }
        Box(
            Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        ) {
            PetTypeButton(
                text = "Собаки",
                type = PetType.dogs,
//                callback = callback
            )
            Divider(color = textWhite, thickness = dogsUnderlined)
        }
        Box(
            Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        ) {
            PetTypeButton(
                text = "Кошки",
                type = PetType.cats,
//                callback = callback
            )
            Divider(color = textWhite, thickness = catsUnderlined)
        }
        Box(
            Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        ) {
            PetTypeButton(
                text = "Другие",
                type = PetType.other,
//                callback = callback
            )
            Divider(color = textWhite, thickness = otherUnderlined)
        }
    }
}
