package com.example.petproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.petproject.consts.uiConsts.ShowLoginScreen
import com.example.petproject.consts.uiConsts.ShowRegisterScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color.White
            ) {
                ShowScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ShowScreen(){
//    ShowLoginScreen()
    ShowRegisterScreen()
}








