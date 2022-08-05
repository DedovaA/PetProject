package com.example.petproject.authorizationScreen

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.petproject.navigation.AppNavigation
import com.example.petproject.navigation.mainGraph
import com.example.petproject.network.NetworkLayer
import com.example.petproject.prefStorage.PrefService
import com.example.petproject.repo.LoginData
import com.example.petproject.repo.RegisterData
import com.example.petproject.statesEnum.AuthFormType
import com.example.petproject.utils.EMPTY_STRING
import com.example.petproject.utils.isEmailValid
import com.example.petproject.utils.isEmptyField
import com.example.petproject.utils.isPasswordMatch
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val network: NetworkLayer,
    private val preferences: PrefService,
    private val navigation: AppNavigation
) : ViewModel() {

    /**
     * auth fields focus flag
     */
    private val _focusEnable = MutableLiveData<Boolean>()
    val focusEnable: LiveData<Boolean> = _focusEnable
    private fun setFocusEnable(focus: Boolean) {
        _focusEnable.postValue(focus)
    }

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
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name
    fun setName(name: String?) {
        _name.postValue(name ?: EMPTY_STRING)
    }

    private val _nameIsValid = MutableLiveData<Boolean>()
    val nameIsValid: LiveData<Boolean> = _nameIsValid
    private fun setNameIsValid(state: Boolean) {
        _nameIsValid.postValue(state)
    }

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email
    fun setEmail(email: String?) {
        _email.postValue(email ?: EMPTY_STRING)
    }

    private val _emailIsValid = MutableLiveData<Boolean>()
    val emailIsValid: LiveData<Boolean> = _emailIsValid
    private fun setEmailIsValid(state: Boolean) {
        _emailIsValid.postValue(state)
    }

    private val _password = MutableLiveData<String>()
    val password: LiveData<String> = _password
    fun setPassword(password: String?) {
        _password.postValue(password ?: EMPTY_STRING)
    }

    private val _passwordIsValid = MutableLiveData<Boolean>()
    val passwordIsValid: LiveData<Boolean> = _passwordIsValid
    private fun setPasswordIsValid(state: Boolean) {
        _passwordIsValid.postValue(state)
    }

    private val _passwordConfirm = MutableLiveData<String>()
    val passwordConfirm: LiveData<String> = _passwordConfirm
    fun setPasswordConfirm(password: String?) {
        _passwordConfirm.postValue(password ?: EMPTY_STRING)
    }

    private val _passwordConfirmIsValid = MutableLiveData<Boolean>()
    val passwordConfirmIsValid: LiveData<Boolean> = _passwordConfirmIsValid
    private fun setPasswordConfirmValid(state: Boolean) {
        _passwordConfirmIsValid.postValue(state)
    }

    /**
     * Сбросить данные/состояние экрана
     */
    private fun clearScreenStates() {
        setNameIsValid(true)
        setEmailIsValid(true)
        setPasswordIsValid(true)
        setPasswordConfirmValid(true)
    }
    private fun clearDataScreen() {
        setName("")
        setEmail("")
        setPassword("")
        setPasswordConfirm("")
    }

    /**
     * UseCase: "Вход / Регистрация" (Button-> onClick)
     */
    fun switchAuthScreen(type: AuthFormType) {
        clearDataScreen()
        clearScreenStates()
        setAuthScreen(type)
    }

    /**
     * UseCase: "Войти" (Button-> onClick)
     */
    fun loginValidation() {
        val emailState = when {
            isEmptyField(email.value ?: EMPTY_STRING) -> false
            !isEmailValid(email.value ?: EMPTY_STRING) -> false
            else -> true
        }
        setEmailIsValid(emailState)

        val passwordState = when {
            isEmptyField(password.value ?: EMPTY_STRING) -> false
            else -> true
        }
        setPasswordIsValid(passwordState)
        if (emailState && passwordState) {
            setFocusEnable(false)
            login()
        }
    }

    /**
     * UseCase: "Зарегистрироваться" (Button-> onClick)
     */
    fun registerValidation() {
        val nameState = when {
            isEmptyField(name.value ?: EMPTY_STRING) -> false
            else -> true
        }
        setNameIsValid(nameState)

        val emailState = when {
            isEmptyField(email.value ?: EMPTY_STRING) -> false
            !isEmailValid(email.value ?: EMPTY_STRING) -> false
            else -> true
        }
        setEmailIsValid(emailState)

        val passwordState = when {
            isEmptyField(password.value ?: EMPTY_STRING) -> false
            else -> true
        }
        setPasswordIsValid(passwordState)

        val passwordConfirmState = when {
            isEmptyField(password.value ?: EMPTY_STRING) -> false
            !isPasswordMatch(
                password.value ?: EMPTY_STRING,
                passwordConfirm.value ?: EMPTY_STRING
            ) -> false
            else -> true
        }
        setPasswordConfirmValid(passwordConfirmState)
        if (nameState && emailState && passwordConfirmState) {
            setFocusEnable(false)
            register()
        }
    }

    fun login() {
        viewModelScope.launch {
            val tokens = network
                .loginRequest(
                    LoginData(email = _email.value!!, password = _password.value!!)
                )
            if (tokens != null) {
                preferences.saveTokens(tokens.accessToken, tokens.refreshToken)
                navigation.navigateTo(mainGraph)
            } else setFocusEnable(true)
        }
    }

    fun proceedWithoutLogin(){
        navigation.navigateTo(mainGraph)
    }

    fun register() {
        viewModelScope.launch {
            val tokens = network
                .registerRequest(
                    RegisterData(
                        email = _email.value!!,
                        password = _password.value!!,
                        userName = _name.value!!
                    )
                )
            if (tokens != null) {
                preferences.saveTokens(tokens.accessToken, tokens.refreshToken)
            } else setFocusEnable(true)
        }
    }
}
