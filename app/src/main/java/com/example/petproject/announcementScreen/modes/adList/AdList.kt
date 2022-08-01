package com.example.petproject.announcementScreen.modes.adList

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
import com.example.petproject.announcementScreen.MainViewModel
import com.example.petproject.repo.DataAnnouncement
import com.example.petproject.statesEnum.PetType

@Composable
fun AdListBox(viewModel: MainViewModel) {
    val petType = viewModel.petType.observeAsState(PetType.All)
    val adList = viewModel.visibleAdList.observeAsState(listOf())

    viewModel.getAdList(petType.value)//TODO переделать на launched effect

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        PetTypeSwitchButtonGroup(
            petType = petType.value,
            callbackPetType = viewModel::switchPetTypeButton,
        )

        AdList(
            adList = adList.value!! //TODO перенаправить на пустой экран
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun AdList(
    adList: List<DataAnnouncement>
){
    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterHorizontally),
        content = {
            items(adList){ item ->
                PetCard(item)
            }
        }
    )
}

