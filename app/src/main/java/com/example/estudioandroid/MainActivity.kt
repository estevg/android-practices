package com.example.estudioandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.estudioandroid.alertDialog.AlertDialogActivity
import com.example.estudioandroid.broadcastReceiver.BroadcastReceiver
import com.example.estudioandroid.dataStore.DataStore
import com.example.estudioandroid.sharedPreferences.SharedPreferences
import com.example.estudioandroid.databinding.ActivityMainBinding
import com.example.estudioandroid.navigateActivity.MainNavigate
import com.example.estudioandroid.services.ServiceActivity
import com.example.estudioandroid.superbase.MainActivitySuperBase
import com.example.estudioandroid.viewPager2.ViewPagerActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val btnSharedPreferences = binding.sharedPreferences
        val btnNavigateActivity = binding.NavigateActivity
        val btnDataStore = binding.dataStoreView
        val btnServices = binding.btnService
        val btnBroadcastReceiver = binding.btnBroadCastReceiver
        val btnSuperBase = binding.btnSuperBase
        val btnDialog = binding.btnDialog
        val viewPager = binding.ViewPager


        viewPager.setOnClickListener { navigateViewPager() }
        btnSuperBase.setOnClickListener { navigateSuperBase() }
        btnDialog.setOnClickListener { navigateDialog() }
        btnBroadcastReceiver.setOnClickListener { navigateBroadCast() }
        btnServices.setOnClickListener { navigateService() }
        btnDataStore.setOnClickListener { navigateDataStore() }
        btnNavigateActivity.setOnClickListener { navigateActivity() }
        btnSharedPreferences.setOnClickListener { navigateSharedPreferences() }

    }

    private fun navigateViewPager() {
        startActivity(Intent(this, ViewPagerActivity::class.java))
    }

    private fun navigateDialog() {
        startActivity(Intent(this, AlertDialogActivity::class.java))
    }

    private fun navigateSuperBase() {
        startActivity(Intent(this, MainActivitySuperBase::class.java))
    }

    private fun navigateBroadCast() {
        startActivity(Intent(this, BroadcastReceiver::class.java))
    }

    private fun navigateService() {
        startActivity(Intent(this, ServiceActivity::class.java))
    }

    private fun navigateDataStore() {
        startActivity(Intent(this, DataStore::class.java))
    }

    private fun navigateSharedPreferences (){
        startActivity(Intent(this, SharedPreferences::class.java))
    }

    private fun navigateActivity (){
        startActivity(Intent(this, MainNavigate::class.java))
    }
}