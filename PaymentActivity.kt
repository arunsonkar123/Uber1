package com.example.ubercloneapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PaymentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment)

        val tvPaymentService = findViewById<TextView>(R.id.tvPaymentService)
        val tvRoute = findViewById<TextView>(R.id.tvRoute)
        val paymentGroup = findViewById<RadioGroup>(R.id.paymentGroup)
        val btnConfirmRide = findViewById<Button>(R.id.btnConfirmRide)

        val serviceName = intent.getStringExtra("service_name") ?: "Trip"
        val pickup = intent.getStringExtra("pickup") ?: "Current Location"
        val drop = intent.getStringExtra("drop") ?: "Destination"

        tvPaymentService.text = "Service: $serviceName"
        tvRoute.text = "Route: $pickup → $drop"

        btnConfirmRide.setOnClickListener {
            val paymentMode = when (paymentGroup.checkedRadioButtonId) {
                R.id.rbUpi -> "UPI"
                R.id.rbCard -> "Card"
                else -> "Cash"
            }

            val ride = RideItem(
                serviceName = serviceName,
                pickup = pickup,
                drop = drop,
                fare = "₹199",
                paymentMode = paymentMode
            )

            RideManager.bookingHistory.add(0, ride)

            startActivity(Intent(this, BookingHistoryActivity::class.java))
        }
    }
}