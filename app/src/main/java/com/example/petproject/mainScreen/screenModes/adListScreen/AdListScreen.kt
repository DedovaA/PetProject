package com.example.petproject.mainScreen.screenModes.adListScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petproject.mainScreen.MainScreenViewModel
import com.example.petproject.model.DataAnnouncement
import com.example.petproject.statesEnum.PetType

@Composable
fun AdListScreen(viewModel: MainScreenViewModel) {
    val filterType = viewModel.filterType.observeAsState(PetType.All)
    val adList = viewModel.visibleAdList.observeAsState(null)
    val loadIndicator = viewModel.loadingIndicator.observeAsState(true)

    viewModel.getAdList(filterType.value)//TODO переделать на launched effect

    Box(modifier = Modifier.fillMaxSize()){
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            PetTypeSwitchButtonGroup(
                petType = filterType.value,
                callbackPetType = viewModel::switchPetTypeButton,
            )
            when(adList.value){
                null -> LoadingScreen(loading = loadIndicator.value)
                else -> List( adList = adList.value!! )
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun List(
    adList: List<DataAnnouncement>
){
    LazyVerticalGrid(
        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 20.dp),
        cells = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        content = {
            items(adList){ item ->
                PetCard(item)
            }
        }
    )
}