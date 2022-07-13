package com.example.petproject.network.userData

data class LoginData(
    val email: String,
    val password: String
)

data class RegisterData(
    val name: String,
    val email: String,
    val password: String
)

data class LoginTokens(
    val accessToken: String,
    val refreshToken: String
)