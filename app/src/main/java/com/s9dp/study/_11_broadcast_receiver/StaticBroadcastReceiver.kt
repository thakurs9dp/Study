package com.s9dp.study._11_broadcast_receiver

import android.app.Activity
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast

class StaticBroadcastReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {

            val isAirplaneModeOn = intent.getBooleanExtra("state", false)
            if (isAirplaneModeOn) {
                (context as? Activity)?.runOnUiThread {
                    Toast.makeText(context, "Airplane Mode Enabled", Toast.LENGTH_SHORT).show()
                }
            } else {
                (context as? Activity)?.runOnUiThread {
                    Toast.makeText(context, "Airplane Mode Disabled", Toast.LENGTH_SHORT).show()
                }
            }

            Log.d("LogAirplaneMode", "The receiver status $isAirplaneModeOn")
        }
    }

}