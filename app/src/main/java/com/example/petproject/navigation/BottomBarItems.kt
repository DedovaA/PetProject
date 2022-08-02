package com.example.petproject.navigation

import com.example.petproject.R

sealed class BottomBarItems(
    val iconId: Int,
    val selectIconId: Int,
    val route: String,
    val label: String
){
    object AdList: BottomBarItems( R.drawable.nav_paw_icon, R.drawable.nav_select_paw_icon, mainGraph, "Объявления")
    object CreateAd: BottomBarItems( R.drawable.nav_plus_icon, R.drawable.nav_select_plus_icon, createAd, "Создать объявление")
    object Profile: BottomBarItems(R.drawable.nav_profile_icon, R.drawable.nav_select_profile_icon, profile, "Профиль")
}
