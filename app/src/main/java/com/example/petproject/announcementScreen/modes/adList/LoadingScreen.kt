package com.example.petproject.announcementScreen.modes.adList

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petproject.consts.uiConsts.mainBlue

@Composable
fun LoadingScreen(loading: Boolean){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ){
        if (loading) {
            CircularProgressIndicator(
                modifier = Modifier
                    .padding(bottom = 24.dp),
                color = mainBlue
            )
        }
    }
}