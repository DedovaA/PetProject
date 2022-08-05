package com.example.petproject.announcementScreen

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
import com.example.petproject.announcementScreen.modes.adList.AdList
import com.example.petproject.announcementScreen.modes.adList.AdListViewModel
import com.example.petproject.announcementScreen.modes.createAd.CreateAd
import com.example.petproject.announcementScreen.modes.userProfile.ShowUserProfile
import com.example.petproject.navigation.BottomBarItems

@Composable
fun MainScreen(viewModel: AdListViewModel){
    val tabsNavigator = rememberNavController()
    val currentTab = remember { MutableLiveData(BottomBarItems.AdList.route) }
    val currentTabObservable = currentTab.observeAsState(BottomBarItems.AdList.route)

    Scaffold(
        bottomBar = {
            BottomBar(
                currentRoute = currentTabObservable.value,
                onItemClick = {
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
                    AdList(viewModel = viewModel)
                }
                composable(route = BottomBarItems.CreateAd.route) {
                    CreateAd()//TODO
                }
                composable(route = BottomBarItems.Profile.route) {
                    ShowUserProfile()//TODO
                }
            }
        }
    }



}

