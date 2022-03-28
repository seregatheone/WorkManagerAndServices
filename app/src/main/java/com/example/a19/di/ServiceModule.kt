package com.example.a19.di

import com.example.a19.boundservise.MyConnection
import com.example.a19.boundservise.MyService
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module(includes = [BindService::class, ProvidesServiceStuff::class])
class ServiceModule {

}
@Module
abstract class BindService{
    @ContributesAndroidInjector
    abstract fun bindService(): MyService
}
@Module
class ProvidesServiceStuff{
    @Provides
    fun provideConnection(): MyConnection = MyConnection()
}

