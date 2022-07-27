package com.example.petproject.navigation

import androidx.navigation.NavHostController

interface AppNavigation {
    var controller: NavHostController?
    fun navigateTo(rout: String)
}