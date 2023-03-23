package com.example.estudioandroid.services

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log


class MyService : Service() {

    private val TAG = "MyService"

    override fun onBind(p0: Intent?): IBinder? = null

    init {
        Log.d(TAG, "Service Running")
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "Service create")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
       val stringExtra = intent?.getStringExtra("EXTRA_MENSAJE")

        stringExtra.let {
            Log.d(TAG, "$it")

            /*Finalizar el servicio desde el servicio*/
            if(it == "FINALIZAR"){
                stopSelf()
            }

        }

        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "Service destroy")
    }
}