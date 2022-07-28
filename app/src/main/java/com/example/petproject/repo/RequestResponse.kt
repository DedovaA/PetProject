package com.example.petproject.repo

data class RequestResponse<ResponseType>(
    val code: Int,
    val message: String,
    val result: ResponseType?
)