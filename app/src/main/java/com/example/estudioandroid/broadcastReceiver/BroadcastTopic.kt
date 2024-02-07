package com.example.estudioandroid.broadcastReceiver

import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.wifi.WifiManager
import android.os.BatteryManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.estudioandroid.R
import com.example.estudioandroid.databinding.ActivityBroadcastTopicBinding

class BroadcastTopic : AppCompatActivity() {

    lateinit var binding: ActivityBroadcastTopicBinding

    private lateinit var connectManager: ConnectivityManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBroadcastTopicBinding.inflate(layoutInflater)
        setContentView(binding.root)

        connectManager =
            applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    }

    override fun onResume() {
        super.onResume()


        registerReceiver(getBatteryLevel, IntentFilter(Intent.ACTION_BATTERY_CHANGED))
        registerReceiver(getAirplaneMode, IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED))
        registerReceiver(getWifiState, IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION))
    }

    override fun onPause() {
        super.onPause()
        unregisterReceiver(getBatteryLevel)
        unregisterReceiver(getAirplaneMode)
        unregisterReceiver(getWifiState)

        /*Validar el estado del wifi una unica vez */
        Log.d("BroadCast", "${hasWifi()}")
        Log.d("BroadCast", "${getBatterLevel()}")
    }

    private val getBatteryLevel = object : android.content.BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val batteryLevel = intent?.getIntExtra(BatteryManager.EXTRA_LEVEL, 0)


            batteryLevel.let { porcentaje ->
                binding.txtBatteryLevel.text = "Porcentaje de bateria: $porcentaje"
            }

        }
    }


    private val getAirplaneMode = object : android.content.BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val airplaneMode = intent?.getBooleanExtra("state", false)

            airplaneMode?.let { isAirplaneMode ->

                if (isAirplaneMode) {
                    binding.imagePlanet.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@BroadcastTopic,
                            R.drawable.ic_baseline_local_airport_24
                        )
                    )
                } else {
                    binding.imagePlanet.setImageDrawable(
                        ContextCompat.getDrawable(
                            this@BroadcastTopic,
                            R.drawable.ic_baseline_airplanemode_inactive_24
                        )
                    )
                }

            }
        }
    }


    private val getWifiState = object : android.content.BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val wifiState =
                intent?.getIntExtra(WifiManager.EXTRA_WIFI_STATE, WifiManager.WIFI_STATE_UNKNOWN)

            wifiState?.let {
                when (it) {
                    WifiManager.WIFI_STATE_ENABLED -> {
                        binding.txtWifi.text = "Wifi: Activo"
                    }

                    WifiManager.WIFI_STATE_DISABLED -> {
                        binding.txtWifi.text = "Wifi: Desactivado"
                    }

                    WifiManager.WIFI_STATE_UNKNOWN -> {
                        binding.txtWifi.text = "Wifi: Error"
                    }
                }
            }
        }
    }


    /* getSystemService */

    private fun hasWifi(): Boolean = connectManager.activeNetwork?.let { network ->
        connectManager.getNetworkCapabilities(network)
            ?.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
    } ?: false

    private fun getBatterLevel(): Int {
        val bm = applicationContext.getSystemService(Context.BATTERY_SERVICE) as BatteryManager
        return bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)
    }


}