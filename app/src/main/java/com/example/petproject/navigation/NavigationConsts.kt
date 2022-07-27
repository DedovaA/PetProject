package com.example.petproject.navigation

//screens
sealed class Screen(val name: String){
    object AuthScreen: Screen("auth_screen")
    object MainScreen: Screen("main_screen")
}

//routs
const val authGraph = "AuthGraph"
const val mainGraph = "MainGraph"