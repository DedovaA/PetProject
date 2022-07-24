package com.example.petproject.announcementScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.petproject.AuthViewModel
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.*
import com.example.petproject.repo.DataAnnouncement
import com.example.petproject.utils.EMPTY_STRING

@Composable
fun AdListScreen(viewModel: AuthViewModel) {
    val petType = viewModel.petType.observeAsState(EMPTY_STRING)
    val adList = viewModel.visibleAdList.observeAsState(listOf())

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        viewModel.getAdList(petType.value)

        PetTypeSwitchButtonGroup(
            petType = petType.value,
            callbackPetType = viewModel::switchPetTypeButton,
        )
        AdList(
            adList = adList.value!! //TODO перенаправить на пустой экран
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun AdList(
    adList: List<DataAnnouncement>
){
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        content = {
            items(adList){ item ->
                PetCard(item)
            }
        }
    )
}

@Preview
@Composable
fun PetTypeButton(
    text: String,
    type: String,
    callbackPetType: (String) -> Unit
) {
    TextButton(
        onClick = {
            callbackPetType(type)
        },
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
    petType: String,
    callbackPetType: (String) -> Unit
) {
    var allUnderlined: Dp = 1.dp
    var dogsUnderlined: Dp = 1.dp
    var catsUnderlined: Dp = 1.dp
    var otherUnderlined: Dp = 1.dp

    when (petType){
        "dog" -> dogsUnderlined = 5.dp
        "cat" -> catsUnderlined = 5.dp
        "other" -> otherUnderlined = 5.dp
        else -> allUnderlined = 5.dp
    }
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        ) {
            PetTypeButton(
                text = "Все",
                type = EMPTY_STRING,
                callbackPetType = callbackPetType
            )
            Divider(color = textWhite, thickness = allUnderlined)
        }
        Box(
            modifier = Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        ) {
            PetTypeButton(
                text = "Собаки",
                type = "dog",
                callbackPetType = callbackPetType
            )
            Divider(color = textWhite, thickness = dogsUnderlined)
        }
        Box(
            modifier = Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        ) {
            PetTypeButton(
                text = "Кошки",
                type = "cat",
                callbackPetType = callbackPetType
            )
            Divider(color = textWhite, thickness = catsUnderlined)
        }
        Box(
            modifier = Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        ) {
            PetTypeButton(
                text = "Другие",
                type = "other",
                callbackPetType = callbackPetType
            )
            Divider(color = textWhite, thickness = otherUnderlined)
        }
    }
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
/**
@Preview
@Composable
fun NoAdsScreen() {
    Text(
        text = stringResource(R.string.no_ads_yet),
        color = validationGray,
        style = authFieldTextStyle
    )
}
 */
