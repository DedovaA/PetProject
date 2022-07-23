package com.example.petproject.network

import com.example.petproject.repo.AnnouncementList
import com.example.petproject.repo.LoginData
import com.example.petproject.repo.LoginToken
import com.example.petproject.repo.RegisterData
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiFactory : NetworkLayer {

    private val BASE_URL = "https://petsproject.issart.com/api/1.0.0/"

    private val client = OkHttpClient.Builder()
        .callTimeout(timeout = 5, TimeUnit.SECONDS)
        .addInterceptor(
            HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }
        )
        .build()

    private var retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()

    private val apiService: ApiService = retrofit.create(ApiService::class.java)

    override suspend fun healthCheckRequest() {
        val responseHealthCheck = apiService.healthCheck()
        when (responseHealthCheck.code()) {
            200 -> {
                println("*** OK ***")
            }
            else -> {
                println("******* ErrorCode : ${responseHealthCheck.code()}")
            }
        }
    }

    override suspend fun loginRequest(loginData: LoginData): LoginToken? {
        val responseLogin = apiService.login(loginData)
        return when (responseLogin.code()) {
            200 -> {
                println("*** WELLCOME ***")
                responseLogin.body()
            }
            else -> {
                val errorMessage = when {
                    responseLogin.code() == 404 -> "User with this creds not found."
                    responseLogin.code() == 415 -> "Unsupported Media Type, or empty body."
                    responseLogin.code() == 422 -> "Wrong JSON format."
                    else -> "Some internal error."
                }
                println("******* LOGIN ERROR : $errorMessage")
                null
            }
        }
    }

    override suspend fun registerRequest(registerData: RegisterData): LoginToken? {
        val responseRegister = apiService.register(registerData)
        return when (responseRegister.code()) {
            200 -> {
                println("******* WELLCOME *******")
                responseRegister.body()
            }
            else -> {
                val errorMessage = when {
                    responseRegister.code() == 409 -> "User with this creds already exists."
                    responseRegister.code() == 415 -> "Unsupported Media Type, or empty body."
                    responseRegister.code() == 422 -> "Wrong JSON format."
                    else -> "Some internal error."
                }
                println("******* REGISTER ERROR : $errorMessage")
                null
            }
        }
    }

    override suspend fun getAnnouncementsRequest(petType: String): AnnouncementList? {
        val responseAnnouncementList = apiService.getAnnouncements(petType)
        return when (responseAnnouncementList.code()){
            200 -> {
                println("******* ADLIST DOWNLOADED ********")
                responseAnnouncementList.body()
            }
            else -> {
                val errorMessage = when {
                    responseAnnouncementList.code() == 415 -> "Unsupported Media Type, or empty body."
                    responseAnnouncementList.code() == 422 -> "Wrong parameter."
                    responseAnnouncementList.code() == 426 -> "Token outdated."
                    else -> "Some internal error."
                }
                println("******* ERROR ADLIST DOWNLOAD : $errorMessage")
                null
            }
        }
    }


}
