package com.example.estudioandroid.navigateActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.estudioandroid.R
import com.example.estudioandroid.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private var name: String? = null
    lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        intent.extras?.let {
                bundle -> name = bundle.getString("name") ?: "Second Activity"
        }

        binding.tvTitle.text = name


        binding.btnNavigate.setOnClickListener{
            val intent = Intent()
            intent.putExtra("name2", "Hello from second activity")
            setResult(RESULT_OK, intent)
            finish()
        }

    }
}