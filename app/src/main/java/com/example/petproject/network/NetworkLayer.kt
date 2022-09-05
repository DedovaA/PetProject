package com.example.petproject.network

import com.example.petproject.model.*

interface NetworkLayer {
    suspend fun healthCheckRequest()
    suspend fun loginRequest(loginData: LoginData): LoginToken?
    suspend fun registerRequest(registerData: RegisterData): LoginToken?
    suspend fun getAnnouncementsRequest(petType: String): List<DataAnnouncement>?
}
