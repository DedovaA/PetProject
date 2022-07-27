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
import com.example.petproject.loginScreen.AuthorizationScreen
import com.example.petproject.navigation.*
import com.example.petproject.repo.prefStorage.PrefService
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
                        navigation(startDestination = Screen.AuthScreen.name, route = authGraph) {
                            composable(route = Screen.AuthScreen.name){
                                val authModel = hiltViewModel<AuthViewModel>()
                                AuthorizationScreen(viewModel = authModel)
                            }

                        }
                        navigation(startDestination = Screen.MainScreen.name, route = mainGraph) {
                            composable(route = Screen.MainScreen.name){
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