package com.example.a19.ui.startFragment

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Message
import android.os.RemoteException
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a19.R
import com.example.a19.boundservise.MyConnection
import com.example.a19.boundservise.MyService
import com.example.a19.data.retrofit.CatFactModelModel
import com.example.a19.databinding.FragmentStartBinding
import dagger.android.support.DaggerFragment
import javax.inject.Inject

private const val MSG_SAY_HELLO = 1
class StartFragment : DaggerFragment() {

    @Inject
    lateinit var myConnection : MyConnection

    @Inject
    lateinit var startFragmentViewModelFactory : StartFragmentViewModelFactory

    private val adapter by lazy{ RecViewAdapter() }

    private val startFragmentViewModel : StartFragmentViewModel by viewModels{startFragmentViewModelFactory}

    private var _binding : FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onAttach(activity: Activity) {
        Intent(activity, MyService::class.java).also { intent ->
            activity.bindService(intent, myConnection, Context.BIND_AUTO_CREATE)
        }
        super.onAttach(activity)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStartBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val recView = binding.recView
        val layoutManager = LinearLayoutManager(requireContext())

        recView.layoutManager = layoutManager
        adapter.allData = emptyList()
        recView.adapter = adapter

        binding.requestButton.setOnClickListener {
            val msg: Message = Message.obtain(null, MSG_SAY_HELLO, 0, 0)
            try {
                myConnection.mService?.send(msg)
            } catch (e: RemoteException) {
                e.printStackTrace()
            }
            val res = startFragmentViewModel.getDataFromInternet()
            retrieveList(res)
        }

        binding.newFragment.setOnClickListener {
            findNavController().navigate(R.id.action_startFragment_to_workManagerFragment)
        }
        super.onViewCreated(view, savedInstanceState)
    }
    private fun retrieveList(requests: CatFactModelModel) {
        adapter.apply {
            setRequestsData(requests)
        }
    }

}
