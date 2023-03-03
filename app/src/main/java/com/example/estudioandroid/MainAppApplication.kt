package com.example.estudioandroid

import android.app.Application
import com.example.estudioandroid.sharedPreferences.Prefs

class MainApplication: Application() {

    companion object {
        lateinit var prefs: Prefs
    }

    override fun onCreate() {
        super.onCreate()
        prefs = Prefs(applicationContext)
    }
}