package com.example.a19.ui.workManagerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.work.ExistingPeriodicWorkPolicy
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import com.example.a19.databinding.FragmentWorkManagerBinding
//import com.example.a19.workmanager.UploadWorker
//import com.example.a19.workmanager.WorkScheduler
import dagger.android.support.DaggerFragment
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class WorkManagerFragment : DaggerFragment() {

//    @Inject
//    lateinit var workScheduler : WorkScheduler

    private var _binding : FragmentWorkManagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWorkManagerBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        binding.startInjectedWorkManager.setOnClickListener {
//            workScheduler.schedulerInjectedWorker()
//        }
//        setPeriodicTimeWorkRequest()
        super.onViewCreated(view, savedInstanceState)
    }

//    private fun setPeriodicTimeWorkRequest() {
//        val periodicWorkRequest = PeriodicWorkRequest.Builder(UploadWorker::class.java, 5, TimeUnit.SECONDS).build()
//        WorkManager.getInstance(requireContext())
//            .enqueueUniquePeriodicWork(
//                "periodicImageDownload",
//                ExistingPeriodicWorkPolicy.KEEP,
//                periodicWorkRequest
//            )
//    }

}