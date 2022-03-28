package com.example.a19.workmanager

import android.content.Context
import android.util.Log
import androidx.work.ListenableWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.a19.data.RetrofitRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

//class UploadWorker(appContext: Context, workerParams: WorkerParameters):
//       Worker(appContext, workerParams) {
//    override fun doWork(): Result {
////        CoroutineScope(Dispatchers.IO).launch {
////            val request = retrofitRepository.getUsers()
////        Log.i(TAG, request.body().toString())
////        }
//        Log.i(TAG, "CheckOnWork ${TAG}")
//        return Result.success()
//    }
//    companion object{
//        private const val TAG = "UploadWorker"
//    }
//}