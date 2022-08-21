package com.example.petproject.model

//TODO
data class RequestResponse<ResponseType>(
    val code: Int,
    val message: String,
    val result: ResponseType?
)