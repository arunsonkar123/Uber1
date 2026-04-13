package com.example.ubercloneapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class BookingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        val tvServiceName = findViewById<TextView>(R.id.tvServiceName)
        val tvPickupValue = findViewById<TextView>(R.id.tvPickupValue)
        val tvDropValue = findViewById<TextView>(R.id.tvDropValue)
        val btnProceedPayment = findViewById<Button>(R.id.btnProceedPayment)

        val serviceName = intent.getStringExtra("service_name") ?: "Trip"
        val pickup = intent.getStringExtra("pickup") ?: "Current Location"
        val drop = intent.getStringExtra("drop") ?: "Destination"

        tvServiceName.text = serviceName
        tvPickupValue.text = pickup
        tvDropValue.text = drop

        btnProceedPayment.setOnClickListener {
            val intent = Intent(this, PaymentActivity::class.java)
            intent.putExtra("service_name", serviceName)
            intent.putExtra("pickup", pickup)
            intent.putExtra("drop", drop)
            startActivity(intent)
        }
    }
}