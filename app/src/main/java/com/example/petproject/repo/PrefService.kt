package com.example.petproject.repo

interface PrefService {
    fun saveTokens(accessToken: String, refreshToken: String)
    fun getAccessToken(): String
}