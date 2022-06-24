package com.example.petproject.loginScreen

import androidx.lifecycle.MutableLiveData
import com.example.petproject.statesEnum.AuthFormType

//описывает состояние экрана
data class AuthScreenState(

    //состояние экрана - логин / регистрация
    val authFormType: MutableLiveData<AuthFormType>,

    //состояние поля name - valid / error
    val name: MutableLiveData<String>,

    //состояние поля email - valid / error
    val email: MutableLiveData<String>,

    //состояние поля password - valid / error
    val password: MutableLiveData<String>,

    //состояние поля passwordConfirm - valid / error
    val passwordConfirm: MutableLiveData<String>

)
