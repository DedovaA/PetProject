package com.example.petproject.network

import com.example.petproject.repo.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {
    @GET("tech/healthcheck")
    suspend fun healthCheck(): Response<Void>

    @POST("login/email")
    suspend fun login(@Body loginData: LoginData): Response<LoginToken>

    @POST("register/email")
    suspend fun register(@Body registerData: RegisterData): Response<LoginToken>

    @GET("/announcements")
    suspend fun getAnnouncements(@Body petType: String): Response<AnnouncementList>

}
