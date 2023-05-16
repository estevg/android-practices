package com.example.estudioandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils.replace
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.example.estudioandroid.alertDialog.AlertDialogActivity
import com.example.estudioandroid.broadcastReceiver.BroadcastReceiver
import com.example.estudioandroid.core.toast
import com.example.estudioandroid.dataStore.DataStore
import com.example.estudioandroid.sharedPreferences.SharedPreferences
import com.example.estudioandroid.databinding.ActivityMainBinding
import com.example.estudioandroid.navigateActivity.MainNavigate
import com.example.estudioandroid.permisos.AuthorizationsFragment
import com.example.estudioandroid.services.ServiceActivity
import com.example.estudioandroid.superbase.MainActivitySuperBase
import com.example.estudioandroid.viewPager2.ViewPagerActivity

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }


}