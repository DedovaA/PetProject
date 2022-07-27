package com.example.petproject.di

import android.content.Context
import com.example.petproject.navigation.AppNavigation
import com.example.petproject.navigation.ControllerNavigation
import com.example.petproject.network.ApiFactory
import com.example.petproject.network.NetworkLayer
import com.example.petproject.repo.prefStorage.PrefRepository
import com.example.petproject.repo.prefStorage.PrefService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ServiceModule {

    @Provides
    @Singleton
    fun provideNetworkService(): NetworkLayer = ApiFactory()

    @Provides
    fun providePrefRepository(
        @ApplicationContext
        appContext: Context
    ): PrefService = PrefRepository(appContext)

    @Provides
    @Singleton
    fun provideNavController(): AppNavigation = ControllerNavigation()
}