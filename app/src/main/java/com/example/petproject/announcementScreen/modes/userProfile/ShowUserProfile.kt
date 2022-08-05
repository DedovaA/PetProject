package com.example.petproject.announcementScreen.modes.userProfile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.petproject.announcementScreen.TopBar
import com.example.petproject.consts.uiConsts.petCardBackground

@Preview
@Composable
fun ShowUserProfile(
    textTopBar: String = "Изменение профиля"
){
    Scaffold(
        topBar = { TopBar(textTopBar) }
    )
    {
        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

        }
    }
}