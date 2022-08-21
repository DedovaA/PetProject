package com.example.petproject.mainScreen.screenModes.createAdScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.example.petproject.R
import com.example.petproject.mainScreen.TopBar
import com.example.petproject.viewComponents.buttons.MainButtonWithStarIcon

@Composable
fun UploadPhotoView(
    topBarText: String
){
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(text = topBarText)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            MainButtonWithStarIcon(
                textButton = "Добавить фото",
                iconResourceId = R.drawable.upload_file_icon,
                iconDescription = stringResource(R.string.upload_file_icon),
                callbackOnClick = {  }
            )
        }
    }
}