package com.example.a19


import androidx.work.Configuration
import androidx.work.DelegatingWorkerFactory
import androidx.work.Worker
import com.vikingsen.inject.worker.WorkerFactory
import com.example.a19.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import javax.inject.Inject

class ProjectApplication : DaggerApplication()
//    , Configuration.Provider
{
//    @Inject
//    lateinit var workerFactory: WorkerFactory

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder()
            .application(this)
            .build()
    }

//    override fun getWorkManagerConfiguration(): Configuration =
//        Configuration.Builder()
//            .setWorkerFactory(workerFactory)
//            .build()
}