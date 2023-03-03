package com.example.estudioandroid.sharedPreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.estudioandroid.MainApplication.Companion.prefs
import com.example.estudioandroid.R
import com.example.estudioandroid.databinding.ActivitySharedPreferencesBinding

class SharedPreferences : AppCompatActivity() {

    lateinit var binding: ActivitySharedPreferencesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySharedPreferencesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUi()
        checkUserValues()
    }


    private fun initUi() {
        binding.btnContinue.setOnClickListener {
            accessToDetail()
        }
    }

    private fun accessToDetail() {
        val etName = binding.etName.text.toString()
        if(etName.isNotEmpty()){
            // Save User
            prefs.saveName(etName)
            prefs.saveVip(binding.cbVip.isChecked)
            navigateDetails()
        }else {

        }
    }

    private fun navigateDetails(){
        val intent = Intent(this, ResultActivity::class.java)
        startActivity(intent)
    }

    private fun checkUserValues(){
        if(prefs.getName().isNotEmpty()){
            navigateDetails()
        }
    }
}