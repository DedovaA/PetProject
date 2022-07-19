package com.example.petproject.di

import android.content.Context
import com.example.petproject.network.ApiFactory
import com.example.petproject.network.NetworkLayer
import com.example.petproject.repo.PrefRepository
import com.example.petproject.repo.PrefService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    fun provideNetworkService(): NetworkLayer = ApiFactory()

    @Provides
    fun providePrefRepository(
        @ApplicationContext
        appContext: Context
    ): PrefService = PrefRepository(appContext)

}