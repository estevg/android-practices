package com.example.estudioandroid.sharedPreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.estudioandroid.MainApplication.Companion.prefs
import com.example.estudioandroid.R
import com.example.estudioandroid.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI(){
        binding.logout.setOnClickListener {
            prefs.wipe()
            onBackPressedDispatcher.onBackPressed()
        }
        val username = prefs.getName()
        binding.tvName.text = "Welcome $username"
        if(prefs.getVip()){
            setBackgroundVip()
        }
    }

    private fun setBackgroundVip(){
        binding.container.setBackgroundColor(ContextCompat.getColor(this, R.color.purple_200))
    }


}