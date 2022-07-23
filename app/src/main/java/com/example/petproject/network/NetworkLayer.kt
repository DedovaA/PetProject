package com.example.petproject.network

import com.example.petproject.repo.AnnouncementList
import com.example.petproject.repo.LoginData
import com.example.petproject.repo.LoginToken
import com.example.petproject.repo.RegisterData

interface NetworkLayer {
    suspend fun healthCheckRequest()
    suspend fun loginRequest(loginData: LoginData): LoginToken?
    suspend fun registerRequest(registerData: RegisterData): LoginToken?
    suspend fun getAnnouncementsRequest(petType: String): AnnouncementList?
}
