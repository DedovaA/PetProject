package com.example.petproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel(){
    // instance of LiveData
    private val authFormType = MutableLiveData<AuthFormType>()
    //getter LD
    val state = authFormType
//setter LD
    fun setAuthScreen(type: AuthFormType) {
        authFormType.postValue(type)
    }
}
