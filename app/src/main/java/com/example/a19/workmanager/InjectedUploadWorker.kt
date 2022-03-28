package com.example.a19.workmanager

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.squareup.inject.assisted.Assisted
import com.vikingsen.inject.worker.WorkerInject
//
//class InjectedUploadWorker @WorkerInject constructor(
//    @Assisted appContext: Context, @Assisted workerParams: WorkerParameters
//) : Worker(appContext,workerParams) {
//    override fun doWork(): Result {
//        Log.i(TAG, "CheckOnWork $TAG")
//        return Result.success()
//    }
//    companion object{
//        private const val TAG = "InjectorUploadWorker"
//    }
//}