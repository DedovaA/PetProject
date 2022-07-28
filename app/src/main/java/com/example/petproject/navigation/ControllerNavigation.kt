package com.example.petproject.navigation

import androidx.navigation.NavHostController

class ControllerNavigation: AppNavigation {
    override var controller: NavHostController? = null

    override fun navigateTo(rout: String) {
        controller?.navigate(rout)
    }
}