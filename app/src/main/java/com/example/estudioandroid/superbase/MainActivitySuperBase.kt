package com.example.estudioandroid.superbase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.example.estudioandroid.databinding.ActivityMainSuperBaseBinding
import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.gotrue.providers.builtin.Email
import io.github.jan.supabase.postgrest.Postgrest
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch




class MainActivitySuperBase : AppCompatActivity() {

    private val TAG = "SuperBase"
    lateinit var binding: ActivityMainSuperBaseBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainSuperBaseBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val client = createSupabaseClient(
            supabaseUrl = "xxxx",
            supabaseKey = "xxxx",
        ) {
            install(Postgrest)
            install(GoTrue)
        }

        binding.ingresar.setOnClickListener {
            lifecycleScope.launch(Dispatchers.IO) {
                Log.d(TAG, "RUN  ${Thread.currentThread().name}")
                login(client)
            }
        }
    }

    private suspend fun login(client: SupabaseClient) {
        kotlin.runCatching {
            client.gotrue.signUpWith(Email) {
                email = "test1@gmail.com"
                password = "123456789"
            }
        }.onSuccess {
            Log.d(TAG, "Successfully registered! Check your E-Mail to verify your account.")
        }.onFailure {
            it.printStackTrace()
            Log.d(TAG, "There was an error while registering: ${it.message}")
        }
    }
}