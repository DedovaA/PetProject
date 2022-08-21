package com.example.petproject.mainScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petproject.consts.uiConsts.EMPTY_STRING
import com.example.petproject.model.DataAnnouncement
import com.example.petproject.model.GeoPosition
import com.example.petproject.navigation.AppNavigation
import com.example.petproject.navigation.authGraph
import com.example.petproject.network.NetworkLayer
import com.example.petproject.prefStorage.PrefService
import com.example.petproject.statesEnum.PetType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(
    private val network: NetworkLayer,
    private val preferences: PrefService,
    private val navigation: AppNavigation
) : ViewModel() {

    /**
     * AdList functionality*****************************************************************
     */

    /**
     * Announcement List для отображения
     */
    private val _visibleAdList = MutableLiveData<List<DataAnnouncement>?>()
    val visibleAdList: LiveData<List<DataAnnouncement>?> = _visibleAdList
    private fun setAdList(list: List<DataAnnouncement>?) {
        _visibleAdList.postValue(list)
    }

    /**
     * petType для фильтра списка
     */
    private val _filterType = MutableLiveData<PetType>()
    val filterType: LiveData<PetType> = _filterType
    private fun setPetType(filter: PetType) {
        _filterType.postValue(filter)
    }

    /**
     * progress bar indicator
     */
    private val _loadingIndicator = MutableLiveData<Boolean>()
    val loadingIndicator: LiveData<Boolean> = _loadingIndicator
    private fun setLoading(loading: Boolean) {
        _loadingIndicator.postValue(loading)
    }

    /**
     * onClick - фильтр списка
     */
    fun switchPetTypeButton(petType: PetType){
        setPetType(petType)
    }

    fun getAdList(filterType: PetType){
        viewModelScope.launch {
            val type = when(filterType){
                PetType.Dogs -> "dog"
                PetType.Cats -> "cat"
                PetType.Other -> "other"
                else -> EMPTY_STRING
            }
            val adList = network.getAnnouncementsRequest(type)
            setAdList(adList)
            setLoading(false)
        }
    }

    /**
     * CreateAd functionality*****************************************************************
     */

    /**
     * adPetType - тип нового животного
     */
    private val _adPetType = MutableLiveData<PetType>()
    val adPetType: LiveData<PetType> = _adPetType
    fun setAdPetType(type: PetType) {
        _adPetType.postValue(type)
    }

    /**
     * adAddress - адрес нового животного
     */
    private val _adAddress = MutableLiveData<String>()
    val adAddress: LiveData<String> = _adAddress
    fun setAdAddress(address: String) {
        _adAddress.postValue(address)
    }

    /**
     * adDescription - описание нового животного
     */
    private val _adDescription = MutableLiveData<String>()
    val adDescription: LiveData<String> = _adDescription
    fun setAdDescription(desc: String) {
        _adDescription.postValue(desc)
    }

    /**
     * adHeader - заголовок нового объявления
     */
    private val _adHeader = MutableLiveData<String>()
    val adHeader: LiveData<String> = _adHeader
    fun setAdHeader(header: String) {
        _adHeader.postValue(header)
    }

    /**
     * adPhoto - фото нового животного
     */
    private val _adPhoto = MutableLiveData<String>()
    val adPhoto: LiveData<String> = _adPhoto
    fun setAdPhoto(photo: String) {
        _adPhoto.postValue(photo)
    }

    /**
     * adLocation - координаты нового животного
     */
    private val _adLocation = MutableLiveData<GeoPosition>()
    val adLocation: LiveData<GeoPosition> = _adLocation
    fun setAdLocation(location: GeoPosition) {
        _adLocation.postValue(location)
    }

    /**
     * BottomBarNavigation*****************************************************************
     */

    /**
     * Проверка авторизации
     */
    fun isAuthorized (): Boolean{
        return when (preferences.getAccessToken()) {
            EMPTY_STRING -> false
            null -> false
            else -> true
        }
    }

    fun backToAuthScreen(){
        navigation.navigateTo(authGraph)
    }

}