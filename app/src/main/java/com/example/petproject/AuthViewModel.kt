package com.example.petproject

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
    val authFormType = _authFormType
    fun setAuthScreen(type: AuthFormType) {
        _authFormType.postValue(type)
    }

    /**
     * "Вход / Регистрация" Button-> onClick
     */
    fun switchAuthScreen(type: AuthFormType){
        clearDataScreen()
        clearScreenStates()
        setAuthScreen(type)
    }

    /**
     * Сбросить данные/состояние экрана
     */
    fun clearScreenStates(){
        setNameIsValid(true)
        setEmailIsValid(true)
        setPasswordIsValid(true)
        setPasswordConfirmValid(true)
    }
    fun clearDataScreen(){
        setName("")
        setEmail("")
        setPassword("")
        setPasswordConfirm("")
    }

    /**
     * "Войти" Button-> onClick
     */
    fun loginValidation() {
        clearScreenStates()
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
     * "Зарегистрироваться" Button-> onClick
     */
    fun registerValidation() {
        clearScreenStates()
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

    /**
     * fields (values / states)
     */

    private val _name =  MutableLiveData<String>()
    val name = _name
    fun setName(name: String){
        _name.postValue(name)
    }
    private val _nameIsValid =  MutableLiveData<Boolean>()
    val nameIsValid = _nameIsValid
    fun setNameIsValid(state:Boolean){
        _nameIsValid.postValue(state)
    }

    private val _email =  MutableLiveData<String>()
    val email = _email
    fun setEmail(email: String){
        _email.postValue(email)
    }
    private val _emailIsValid =  MutableLiveData<Boolean>()
    val emailIsValid = _emailIsValid
    fun setEmailIsValid(state:Boolean){
        _emailIsValid.postValue(state)
    }

    private val _password =  MutableLiveData<String>()
    val password = _password
    fun setPassword(password: String){
        _password.postValue(password)
    }
    private val _passwordIsValid =  MutableLiveData<Boolean>()
    val passwordIsValid = _passwordIsValid
    fun setPasswordIsValid(state: Boolean){
        _passwordIsValid.postValue(state)
    }

    private val _passwordConfirm =  MutableLiveData<String>()
    val passwordConfirm = _passwordConfirm
    fun setPasswordConfirm(password: String){
        _passwordConfirm.postValue(password)
    }
    private val _passwordConfirmIsValid =  MutableLiveData<Boolean>()
    val passwordConfirmIsValid = _passwordConfirmIsValid
    fun setPasswordConfirmValid(state: Boolean){
        _passwordConfirmIsValid.postValue(state)
    }

}
