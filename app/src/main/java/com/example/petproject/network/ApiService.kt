package com.example.petproject.network

import com.example.petproject.network.userData.LoginData
import com.example.petproject.network.userData.LoginTokens
import com.example.petproject.network.userData.RegisterData
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiService {

    @GET("tech/healthcheck")
    fun healthcheck(): Completable

    @POST("login/email")
    fun login(loginData: LoginData): Single<LoginTokens>

    @POST("register/email")
    fun register(registerData: RegisterData): Single<LoginTokens>

}