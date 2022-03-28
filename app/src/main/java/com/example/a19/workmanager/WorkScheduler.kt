package com.example.a19.workmanager

import android.content.Context
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.example.a19.di.AppScope
import javax.inject.Inject

//@AppScope
//class WorkScheduler @Inject constructor(
//    private val context : Context
//){
//    private val workManager by lazy{ WorkManager.getInstance(context)}
//
//    private val networkConstraint by lazy {
//        Constraints.Builder()
//            .setRequiredNetworkType(NetworkType.CONNECTED
//            )
//            .build()
//    }
//    fun schedulerWorker(){
//        val workRequest = OneTimeWorkRequestBuilder<UploadWorker>()
//            .setConstraints(networkConstraint)
//            .build()
//
//
//        workManager.apply {
//            enqueue(workRequest)
//        }
//    }
//    fun schedulerInjectedWorker(){
//        val workRequest = OneTimeWorkRequestBuilder<InjectedUploadWorker>()
//            .setConstraints(networkConstraint)
//            .build()
//
//
//        workManager.apply {
//            enqueue(workRequest)
//        }
//    }
//
//}