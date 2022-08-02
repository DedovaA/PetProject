package com.example.petproject.announcementScreen.modes.adList

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.petproject.R
import com.example.petproject.consts.uiConsts.*
import com.example.petproject.repo.DataAnnouncement
import com.example.petproject.statesEnum.PetType

@Composable
fun PetTypeButton(
    text: String,
    type: PetType,
    callbackPetType: (PetType) -> Unit
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

@Composable
fun PetTypeSwitchButtonGroup(
    petType: PetType,
    callbackPetType: (PetType) -> Unit
) {
    var allUnderlined: Dp = 1.dp
    var dogsUnderlined: Dp = 1.dp
    var catsUnderlined: Dp = 1.dp
    var otherUnderlined: Dp = 1.dp

    when (petType){
        PetType.Dogs -> dogsUnderlined = 5.dp
        PetType.Cats -> catsUnderlined = 5.dp
        PetType.Other -> otherUnderlined = 5.dp
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
                text = stringResource(R.string.pet_type_btn_text_all),
                type = PetType.All,
                callbackPetType = callbackPetType
            )
            Divider(color = textWhite, thickness = allUnderlined)
        }
        Box(
            modifier = Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        ) {
            PetTypeButton(
                text = stringResource(R.string.pet_type_btn_text_dogs),
                type = PetType.Dogs,
                callbackPetType = callbackPetType
            )
            Divider(color = textWhite, thickness = dogsUnderlined)
        }
        Box(
            modifier = Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        ) {
            PetTypeButton(
                text = stringResource(R.string.pet_type_btn_text_cats),
                type = PetType.Cats,
                callbackPetType = callbackPetType
            )
            Divider(color = textWhite, thickness = catsUnderlined)
        }
        Box(
            modifier = Modifier.weight(1.0f),
            contentAlignment = Alignment.BottomCenter
        ) {
            PetTypeButton(
                text = stringResource(R.string.pet_type_btn_text_other),
                type = PetType.Other,
                callbackPetType = callbackPetType
            )
            Divider(color = textWhite, thickness = otherUnderlined)
        }
    }
}

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