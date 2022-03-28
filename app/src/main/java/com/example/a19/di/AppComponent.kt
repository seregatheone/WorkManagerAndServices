package com.example.a19.di

import android.app.Application
import android.content.Context
import com.example.a19.ProjectApplication
import com.example.a19.data.RetrofitRepository
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Scope


@[AppScope Component(modules = [AppModule::class, AndroidInjectionModule::class])]
interface AppComponent: AndroidInjector<ProjectApplication> {

    fun provideRetrofitRequestRepository(): RetrofitRepository
    fun provideAppComponent(): AppComponent

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }


}
@Module(includes = [DataModule::class,UIModule::class,ServiceModule::class
//    ,WorkerModule::class
])
class AppModule{
    @[Provides AppScope]
    fun provideContext(application: Application): Context = application.applicationContext


}

@Scope
annotation class AppScope