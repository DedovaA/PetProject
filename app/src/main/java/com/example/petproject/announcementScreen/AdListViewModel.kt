package com.example.petproject.announcementScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petproject.network.NetworkLayer
import com.example.petproject.repo.DataAnnouncement
import com.example.petproject.statesEnum.PetType
import com.example.petproject.utils.EMPTY_STRING
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AdListViewModel @Inject constructor(
    private val network: NetworkLayer
) : ViewModel() {

    /**
     * Announcement List для отображения
     */
    private val _visibleAdList = MutableLiveData<List<DataAnnouncement>?>()
    val visibleAdList: LiveData<List<DataAnnouncement>?> = _visibleAdList
    private fun setAdList(list: List<DataAnnouncement>?) {
        _visibleAdList.postValue(list)
    }

    /**
     * petType для запросов
     */
    private val _petType = MutableLiveData<PetType>()
    val petType: LiveData<PetType> = _petType
    private fun setPetType(type: PetType) {
        _petType.postValue(type)
    }

    /**
     * onClick - фильтр списка
     */
    fun switchPetTypeButton(petType: PetType){
        setPetType(petType)
    }

    fun getAdList(petType: PetType){
        viewModelScope.launch {
            val type = when(petType){
                PetType.Dogs -> "dog"
                PetType.Cats -> "cat"
                PetType.Other -> "other"
                else -> EMPTY_STRING
            }
            val adList = network.getAnnouncementsRequest(type)
            if (adList != null)     //TODO NPE
                setAdList(adList)
        }
    }
}