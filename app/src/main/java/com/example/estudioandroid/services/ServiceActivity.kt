package com.example.estudioandroid.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.estudioandroid.databinding.ActivityServiceBinding

class ServiceActivity : AppCompatActivity() {

    lateinit var binding: ActivityServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityServiceBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnSendService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                startService(it)
                binding.tvTitle.text = "Servicio Iniciado"
            }
        }


        binding.btnFinishedService.setOnClickListener {
            Intent(this, MyService::class.java).also {
                stopService(it)
                binding.tvTitle.text = "Servicio Finalizado"
            }
        }


        binding.btnSend.setOnClickListener {
            Intent(this, MyService::class.java).also {
                it.putExtra("EXTRA_MENSAJE", binding.tvMessage.text.toString())
                startService(it)
                binding.tvMessage.setText("")
                binding.tvTitle.text = "Servicio Finalizado"
            }
        }


    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyService","OnDestroy Activity")
    }
}