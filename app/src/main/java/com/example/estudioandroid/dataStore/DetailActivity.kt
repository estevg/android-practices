package com.example.estudioandroid.dataStore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import com.example.estudioandroid.MainApplication
import com.example.estudioandroid.R
import com.example.estudioandroid.databinding.ActivityDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailActivity : AppCompatActivity() {

    lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)


        lifecycleScope.launch(Dispatchers.IO) {
            getUserProfile().collect {
                withContext(Dispatchers.Main) {
                    binding.tvName.text = it.name
                    if (it.vip) {
                        binding.viewContainer.setBackgroundResource(R.color.purple_500)
                    }
                }
            }
        }

    }


    // Get Data
    private fun getUserProfile() = dataStore.data.map { preferences ->
        UserProfile(
            name = preferences[stringPreferencesKey("name")].orEmpty(),
            vip = preferences[booleanPreferencesKey("vip")] ?: false
        )
    }

}

data class UserProfile(val name: String, val vip: Boolean)