package com.example.petproject.network

import com.example.petproject.repo.*
import retrofit2.Response
import retrofit2.http.*

interface ApiService {
    @GET("tech/healthcheck")
    suspend fun healthCheck(): Response<Void>

    @POST("login/email")
    suspend fun login(@Body loginData: LoginData): Response<LoginToken>

    @POST("register/email")
    suspend fun register(@Body registerData: RegisterData): Response<LoginToken>

    @GET("announcements")
    suspend fun getAnnouncements(@Query("petType") petType:String): Response<List<DataAnnouncement>?>

//    suspend fun postAnnouncements(
//        @Query("petType") petType:String,
//        @Header("Authorization") token: String
//    ): Response<DataAnnoucement>

}
