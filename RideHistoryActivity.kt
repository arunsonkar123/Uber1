package com.example.ubercloneapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RideHistoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ride_history)

        val tvHistory = findViewById<TextView>(R.id.tvHistory)
        val historyText = intent.getStringExtra("history_text")
            ?: "No rides yet.\n\nBook a ride from Services."

        tvHistory.text = historyText
    }
}