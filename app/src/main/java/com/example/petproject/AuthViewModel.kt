package com.example.petproject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.petproject.statesEnum.AuthFormType
import com.example.petproject.utils.isEmailValid
import com.example.petproject.utils.isEmptyField
import com.example.petproject.utils.isPasswordMatch
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor() : ViewModel(){

    /**
     * authScreenType (login / registration)
     */
    private val _authFormType = MutableLiveData<AuthFormType>()
    val authFormType: LiveData<AuthFormType> = _authFormType
    private fun setAuthScreen(type: AuthFormType) {
        _authFormType.postValue(type)
    }

    /**
     * fields (values / states)
     */
    private val _name =  MutableLiveData<String>()
    val name: LiveData<String> = _name
    fun setName(name: String){
        _name.postValue(name)
    }
    private val _nameIsValid =  MutableLiveData<Boolean>()
    val nameIsValid: LiveData<Boolean> = _nameIsValid
    private fun setNameIsValid(state:Boolean){
        _nameIsValid.postValue(state)
    }

    private val _email =  MutableLiveData<String>()
    val email: LiveData<String> = _email
    fun setEmail(email: String){
        _email.postValue(email)
    }
    private val _emailIsValid =  MutableLiveData<Boolean>()
    val emailIsValid: LiveData<Boolean> = _emailIsValid
    private fun setEmailIsValid(state:Boolean){
        _emailIsValid.postValue(state)
    }

    private val _password =  MutableLiveData<String>()
    val password: LiveData<String> = _password
    fun setPassword(password: String){
        _password.postValue(password)
    }
    private val _passwordIsValid =  MutableLiveData<Boolean>()
    val passwordIsValid: LiveData<Boolean> = _passwordIsValid
    private fun setPasswordIsValid(state: Boolean){
        _passwordIsValid.postValue(state)
    }

    private val _passwordConfirm =  MutableLiveData<String>()
    val passwordConfirm: LiveData<String> = _passwordConfirm
    fun setPasswordConfirm(password: String){
        _passwordConfirm.postValue(password)
    }
    private val _passwordConfirmIsValid =  MutableLiveData<Boolean>()
    val passwordConfirmIsValid: LiveData<Boolean> = _passwordConfirmIsValid
    private fun setPasswordConfirmValid(state: Boolean){
        _passwordConfirmIsValid.postValue(state)
    }

    /**
     * Сбросить данные/состояние экрана
     */
    private fun clearScreenStates(){
        setNameIsValid(true)
        setEmailIsValid(true)
        setPasswordIsValid(true)
        setPasswordConfirmValid(true)
    }
    private fun clearDataScreen(){
        setName("")
        setEmail("")
        setPassword("")
        setPasswordConfirm("")
    }

    /**
     * UseCase: "Вход / Регистрация" (Button-> onClick)
     */
    fun switchAuthScreen(type: AuthFormType){
        clearDataScreen()
        clearScreenStates()
        setAuthScreen(type)
    }

    /**
     * UseCase: "Войти" (Button-> onClick)
     */
    fun loginValidation() {
        val emailState = when {
            isEmptyField(email.value.toString()) -> false
            !isEmailValid(email.value.toString()) -> false
            else -> true
        }
        setEmailIsValid(emailState)
        val passwordState = when {
            isEmptyField(password.value.toString()) -> false
            else -> true
        }
        setPasswordIsValid(passwordState)
    }

    /**
     * UseCase: "Зарегистрироваться" (Button-> onClick)
     */
    fun registerValidation() {
        val nameState = when {
            isEmptyField(name.value.toString()) -> false
            else -> true
        }
        setNameIsValid(nameState)

        val emailState = when {
            isEmptyField(email.value.toString()) -> false
            !isEmailValid(email.value.toString()) -> false
            else -> true
        }
        setEmailIsValid(emailState)

        val passwordState = when {
            isEmptyField(password.value.toString()) -> false
            else -> true
        }
        setPasswordIsValid(passwordState)

        val passwordConfirmState = when {
            isEmptyField(password.value.toString()) -> false
            !isPasswordMatch(password.value.toString(), passwordConfirm.value.toString()) -> false
            else -> true
        }
        setPasswordConfirmValid(passwordConfirmState)
    }
}
