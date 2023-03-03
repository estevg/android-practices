package com.example.estudioandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.estudioandroid.sharedPreferences.SharedPreferences
import com.example.estudioandroid.databinding.ActivityMainBinding
import com.example.estudioandroid.navigateActivity.MainNavigate

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnSharedPreferences = binding.sharedPreferences
        val btnNavigateActivity = binding.NavigateActivity

        btnNavigateActivity.setOnClickListener { navigateActivity() }
        btnSharedPreferences.setOnClickListener { navigateSharedPreferences() }
    }

    private fun navigateSharedPreferences (){
        val intent = Intent(this, SharedPreferences::class.java)
        startActivity(intent)
    }

    private fun navigateActivity (){
        val intent = Intent(this, MainNavigate::class.java)
        startActivity(intent)
    }
}