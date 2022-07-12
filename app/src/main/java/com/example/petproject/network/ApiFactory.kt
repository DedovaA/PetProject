package com.example.petproject.network

import android.util.Log
import androidx.compose.ui.input.key.Key.Companion.D
import com.google.gson.GsonBuilder
import com.example.petproject.repo.LoginData
import com.example.petproject.repo.LoginToken
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiFactory : NetworkLayer{

    private val BASE_URL = "https://petsproject.issart.com/api/1.0.0/"

    private val client = OkHttpClient.Builder()
        .callTimeout(5, TimeUnit.SECONDS)
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
                println("OK")
            }
            else -> {
                println("ErrorCode : ${responseHealthCheck.code()}")
            }
        }
    }

    override suspend fun loginRequest(loginData: LoginData): LoginToken? {
        val responseLogin = apiService.login(loginData)
        return when (responseLogin.code()) {
            200 -> {
                println("OK")
                responseLogin.body()
            }
            else -> {
                println("ErrorCode : ${responseLogin.code()}")
                null
            }
        }
    }
}