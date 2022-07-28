package com.example.petproject.network

import com.example.petproject.repo.DataAnnouncement
import com.example.petproject.repo.LoginData
import com.example.petproject.repo.LoginToken
import com.example.petproject.repo.RegisterData
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("tech/healthcheck")
    suspend fun healthCheck(): Response<Void>

    @POST("login/email")
    suspend fun login(@Body loginData: LoginData): Response<LoginToken>

    @POST("register/email")
    suspend fun register(@Body registerData: RegisterData): Response<LoginToken>

    @GET("announcements")
    suspend fun getAnnouncements(@Query("petType") petType:String): Response<List<DataAnnouncement>?>
}
