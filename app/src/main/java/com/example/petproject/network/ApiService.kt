package com.example.petproject.network

import com.example.petproject.model.DataAnnouncement
import com.example.petproject.model.LoginData
import com.example.petproject.model.LoginToken
import com.example.petproject.model.RegisterData
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
