package com.example.petproject.prefStorage

interface PrefService {
    fun saveTokens(accessToken: String, refreshToken: String)
    fun getAccessToken(): String?
}