package com.example.petproject.network

import com.example.petproject.repo.LoginData
import com.example.petproject.repo.LoginToken

interface NetworkLayer {

    suspend fun healthCheckRequest()
    suspend fun loginRequest(loginData: LoginData): LoginToken?
}