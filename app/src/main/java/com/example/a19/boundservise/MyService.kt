package com.example.a19.boundservise

import android.content.Intent
import android.os.*
import android.util.Log
import android.widget.Toast
import com.example.a19.data.RetrofitRepository
import dagger.android.DaggerService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

/** Command to the service to display a message  */
private const val MSG_SAY_HELLO = 1

class MyService : DaggerService() {
    @Inject
    lateinit var requestRepository: RetrofitRepository

    /**
     * Target we publish for clients to send messages to IncomingHandler.
     */
    private lateinit var mMessenger: Messenger

    /**
     * Handler of incoming messages from clients.
     */
    internal class IncomingHandler(private val requestRepository: RetrofitRepository) : Handler() {
        override fun handleMessage(msg: Message) {
            when (msg.what) {
                MSG_SAY_HELLO -> {
                    CoroutineScope(Dispatchers.IO).launch {
                        val request = requestRepository.getUsers()
                        Log.i("request", request.body().toString())
                    }
                    }

                else -> super.handleMessage(msg)
            }
        }
    }

    /**
     * When binding to the service, we return an interface to our messenger
     * for sending messages to the service.
     */
    override fun onBind(intent: Intent): IBinder? {
        Toast.makeText(applicationContext, "binding", Toast.LENGTH_SHORT).show()
        mMessenger = Messenger(IncomingHandler(requestRepository))
        return mMessenger.binder
    }
}