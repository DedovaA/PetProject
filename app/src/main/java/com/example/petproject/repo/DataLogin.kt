package com.example.petproject.repo

data class LoginData(
    val email: String,
    val password: String
    )

data class LoginToken(
    val accessToken: String,
    val refreshToken: String
    )
