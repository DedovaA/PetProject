package com.example.petproject.navigation

//screens
sealed class Screens(val name: String){
    object AuthScreens: Screens("auth_screen")
    object MainScreens: Screens("main_screen")
}