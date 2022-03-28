package com.example.a19.boundservise

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.IBinder
import android.os.Messenger
import javax.inject.Inject
import javax.inject.Singleton

class MyConnection @Inject constructor() : ServiceConnection {
    /** Messenger for communicating with the service.  */
    var mService: Messenger? = null

    /** Flag indicating whether we have called bind on the service.  */
    private var bound: Boolean = false
    override fun onServiceConnected(className: ComponentName, service: IBinder) {
        // This is called when the connection with the service has been
        // established, giving us the object we can use to
        // interact with the service.  We are communicating with the
        // service using a Messenger, so here we get a client-side
        // representation of that from the raw IBinder object.
        mService = Messenger(service)
        bound = true
    }

    override fun onServiceDisconnected(className: ComponentName) {
        // This is called when the connection with the service has been
        // unexpectedly disconnected -- that is, its process crashed.
        mService = null
        bound = false
    }
}