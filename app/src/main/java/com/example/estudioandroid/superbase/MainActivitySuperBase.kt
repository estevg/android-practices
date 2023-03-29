package com.example.estudioandroid.superbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivitySuperBase : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_super_base)
    }
}