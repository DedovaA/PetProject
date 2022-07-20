package com.example.petproject.repo

data class LoginData(
    val email: String,
    val password: String
)

data class RegisterData(
    val email: String,
    val password: String,
    val userName: String
)

data class LoginToken(
    val accessToken: String,
    val refreshToken: String
)
