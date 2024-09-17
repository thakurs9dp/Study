package com.s9dp.study._11_broadcast_receiver

import android.content.BroadcastReceiver
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.s9dp.study.R
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch

class BroadcastMainActivity : AppCompatActivity() {

    private lateinit var airplaneModeReceiver: BroadcastReceiver


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_broadcast_main)

        airplaneModeReceiver = StaticBroadcastReceiver()

        startStaticBroadCastReceiver()

        MainScope().launch {
            println("Hello")
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        stopStaticBroadCastReceiver()
    }


    private fun startStaticBroadCastReceiver() {
        val filter = IntentFilter(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(airplaneModeReceiver, filter)
    }

    private fun stopStaticBroadCastReceiver() {
        unregisterReceiver(airplaneModeReceiver)
    }


    private fun startCustomReceiver() {


    }


}