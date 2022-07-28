package com.example.petproject

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.petproject.announcementScreen.AdListScreen
import com.example.petproject.announcementScreen.AdListViewModel
import com.example.petproject.authorizationScreen.AuthViewModel
import com.example.petproject.authorizationScreen.AuthorizationScreen
import com.example.petproject.navigation.AppNavigation
import com.example.petproject.navigation.Screens
import com.example.petproject.navigation.authGraph
import com.example.petproject.navigation.mainGraph
import com.example.petproject.prefStorage.PrefService
import com.example.petproject.ui.theme.PetProjectTheme
import com.example.petproject.utils.EMPTY_STRING
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var prefRepository: PrefService

    @Inject
    lateinit var navigation: AppNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val startRout = when(prefRepository.getAccessToken()){
            EMPTY_STRING -> authGraph
            else -> mainGraph
        }

        setContent {
            PetProjectTheme{
                val navigationController = rememberNavController()
                navigation.controller = navigationController
                Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                    NavHost(navController = navigationController, startDestination = startRout){
                        navigation(startDestination = Screens.AuthScreens.name, route = authGraph) {
                            composable(route = Screens.AuthScreens.name){
                                val authModel = hiltViewModel<AuthViewModel>()
                                AuthorizationScreen(viewModel = authModel)
                            }

                        }
                        navigation(startDestination = Screens.MainScreens.name, route = mainGraph) {
                            composable(route = Screens.MainScreens.name){
                                val adListModel = hiltViewModel<AdListViewModel>()
                                AdListScreen(viewModel = adListModel)
                            }
                        }
                    }
                }
            }
        }
    }
}