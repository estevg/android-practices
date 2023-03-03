package com.example.estudioandroid.sharedPreferences

import android.content.Context

class Prefs(val context: Context) {


    val SHARED_NAME = "MyDB"
    val SHARED_USER_NAME = "user"
    val SHARED_VIP = "vip"

    val store = context.getSharedPreferences(SHARED_NAME, 0)

    fun saveName(name: String){
        store.edit().putString(SHARED_USER_NAME, name).apply()
    }

    fun saveVip(vip: Boolean){
        store.edit().putBoolean(SHARED_VIP, vip).apply()
    }

    fun getName(): String {
       return store.getString(SHARED_USER_NAME, "") ?: ""
    }

    fun getVip(): Boolean {
        return store.getBoolean(SHARED_VIP, false)
    }

    fun wipe(){
        store.edit().clear().apply()
    }
}