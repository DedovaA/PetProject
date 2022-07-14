package com.example.petproject.network

import io.reactivex.rxjava3.disposables.Disposable

interface Network {
    fun healthcheckRequest(): Disposable
}