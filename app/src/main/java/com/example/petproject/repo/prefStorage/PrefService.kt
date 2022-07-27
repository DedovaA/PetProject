package com.example.petproject.repo.prefStorage

interface PrefService {
    fun saveTokens(accessToken: String, refreshToken: String)
    fun getAccessToken(): String?
}