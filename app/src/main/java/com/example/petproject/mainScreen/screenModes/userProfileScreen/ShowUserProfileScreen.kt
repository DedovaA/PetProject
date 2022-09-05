package com.example.petproject.mainScreen.screenModes.userProfileScreen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.petproject.mainScreen.MainScreenViewModel
import com.example.petproject.mainScreen.TopBar

//TODO
@Composable
fun ShowUserProfileScreen(
    viewModel: MainScreenViewModel
){
    Scaffold(
        topBar = { TopBar("Изменение профиля") }
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