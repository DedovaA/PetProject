package com.example.petproject.network

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ApiFactory : Network{

    private val apiService: ApiService = RetrofitClient.getRetrofitClient().create(ApiService::class.java)

    override fun healthcheckRequest(): Disposable {
        return apiService.healthcheck()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnComplete { println("OK") }
            .doOnError { println("ERROR") }
            .subscribe({ }, { })
    }
}