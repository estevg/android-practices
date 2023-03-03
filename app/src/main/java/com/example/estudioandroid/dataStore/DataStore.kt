package com.example.estudioandroid.dataStore

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.lifecycleScope
import com.example.estudioandroid.databinding.ActivityDataStoreBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


// Create DataStore
val Context.dataStore by preferencesDataStore("USER_PREFERENCES_NAME")

class DataStore : AppCompatActivity() {
    private lateinit var binding: ActivityDataStoreBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataStoreBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val btn = binding.btnContinue

        btn.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                saveValues()
            }
            startActivity(Intent(this, DetailActivity::class.java))
        }

    }


    // Save DataStore
    private suspend fun saveValues() {
        val etName = binding.etName.text.toString()
        val cbVip = binding.cbVip.isChecked

        dataStore.edit {
            preferences -> preferences[stringPreferencesKey("name")] = etName
            preferences[booleanPreferencesKey("vip")] = cbVip
        }
    }
}