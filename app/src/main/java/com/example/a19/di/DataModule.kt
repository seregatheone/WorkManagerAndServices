package com.example.a19.di

import com.example.a19.data.retrofit.RequestService
import com.example.a19.data.retrofit.RequestServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier

@Module(includes = [DataBindsModule::class,NetworkDataModule::class])
class DataModule

@Module
abstract class DataBindsModule {
    @[Binds AppScope]
    abstract fun bindsRequestServiceImpl(requestServiceImpl: RequestServiceImpl): RequestService
}
@Module
class NetworkDataModule {
    @[Provides BaseUrl]
    fun provideBaseUrl(): String = "https://catfact.ninja/"

    @[Provides AppScope]
    fun provideRetrofit(@BaseUrl baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
@Qualifier
annotation class BaseUrl