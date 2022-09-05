package com.example.petproject.mainScreen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.MutableLiveData
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.petproject.mainScreen.screenModes.adListScreen.AdListScreen
import com.example.petproject.mainScreen.screenModes.createAdScreen.CreateAdScreen
import com.example.petproject.mainScreen.screenModes.userProfileScreen.ShowUserProfileScreen
import com.example.petproject.navigation.BottomBarItems

@Composable
fun MainScreen(viewModel: MainScreenViewModel) {
    val tabsNavigator = rememberNavController()
    val currentTab = remember { MutableLiveData(BottomBarItems.AdList.route) }
    val currentTabObservable = currentTab.observeAsState(BottomBarItems.AdList.route)

    Scaffold(
        bottomBar = {
            BottomBar(
                currentRoute = currentTabObservable.value,
                onItemClick = {
                    when (viewModel.isAuthorized()){
                        false -> viewModel.backToAuthScreen()
                        else -> {
                            tabsNavigator.navigate(it) {
                                tabsNavigator.graph.startDestinationRoute?.let { route ->
                                    popUpTo(route) {
                                        saveState = true
                                    }
                                }
                                launchSingleTop = true
                                restoreState = true
                                currentTab.postValue(it)
                            }
                        }
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier.padding(
                PaddingValues(0.dp, 0.dp, 0.dp, it.calculateBottomPadding())
            )
        ) {
            NavHost(navController = tabsNavigator, startDestination = BottomBarItems.AdList.route) {
                composable(route = BottomBarItems.AdList.route) {
                    AdListScreen(viewModel = viewModel)
                }
                composable(route = BottomBarItems.CreateAd.route) {
                    CreateAdScreen(viewModel = viewModel)
                }
                composable(route = BottomBarItems.Profile.route) {
                    ShowUserProfileScreen(viewModel = viewModel)//TODO
                }
            }
        }
    }
}

