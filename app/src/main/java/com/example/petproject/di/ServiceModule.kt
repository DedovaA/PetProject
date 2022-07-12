package com.example.petproject.di

import com.example.petproject.network.ApiFactory
import com.example.petproject.network.NetworkLayer
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun provideNetworkService(): NetworkLayer = ApiFactory()

}