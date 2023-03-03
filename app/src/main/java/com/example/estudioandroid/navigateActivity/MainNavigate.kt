package com.example.estudioandroid.navigateActivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import com.example.estudioandroid.R
import com.example.estudioandroid.databinding.ActivityMainBinding
import com.example.estudioandroid.databinding.ActivityMainNavigateBinding

class MainNavigate : AppCompatActivity() {

    lateinit var binding: ActivityMainNavigateBinding


    lateinit var phrase: TextView

    private val responseLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { activityResult ->
            println(activityResult.resultCode)
            if (activityResult.resultCode == RESULT_OK) {
                activityResult.data.let {
                    phrase.text = it?.getStringExtra("name2") ?: "Test"
                }
                Toast.makeText(this, "OK", Toast.LENGTH_LONG).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainNavigateBinding.inflate(layoutInflater)
        setContentView(binding.root)


        phrase = binding.phrase
        binding.btnNavigate.setOnClickListener { navigateSecondActivity() }
    }

    private fun navigateSecondActivity() {
        val intent = Intent(this, SecondActivity::class.java)

        // Send parameters
        intent.putExtra("name", "User: Esteban Vega")

        /* startActivity(intent)*/

        // Send and receive parameters
        responseLauncher.launch(intent)



    }
}