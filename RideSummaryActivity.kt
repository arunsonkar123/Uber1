package com.example.ubercloneapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RideSummaryActivity : AppCompatActivity() {

    private lateinit var tvPickupSummary: TextView
    private lateinit var tvDropSummary: TextView
    private lateinit var tvDistanceSummary: TextView
    private lateinit var tvVehicleSummary: TextView
    private lateinit var tvFareSummary: TextView
    private lateinit var tvEtaSummary: TextView
    private lateinit var btnBackHome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ride_summary)

        tvPickupSummary = findViewById(R.id.tvPickupSummary)
        tvDropSummary = findViewById(R.id.tvDropSummary)
        tvDistanceSummary = findViewById(R.id.tvDistanceSummary)
        tvVehicleSummary = findViewById(R.id.tvVehicleSummary)
        tvFareSummary = findViewById(R.id.tvFareSummary)
        tvEtaSummary = findViewById(R.id.tvEtaSummary)
        btnBackHome = findViewById(R.id.btnBackHome)

        val pickup = intent.getStringExtra("pickup") ?: ""
        val drop = intent.getStringExtra("drop") ?: ""
        val distance = intent.getDoubleExtra("distance", 0.0)
        val vehicle = intent.getStringExtra("vehicle") ?: ""
        val fare = intent.getDoubleExtra("fare", 0.0)

        tvPickupSummary.text = "Pickup: $pickup"
        tvDropSummary.text = "Drop: $drop"
        tvDistanceSummary.text = "Distance: $distance km"
        tvVehicleSummary.text = "Vehicle: $vehicle"
        tvFareSummary.text = "Fare: ₹%.2f".format(fare)
        tvEtaSummary.text = "Estimated Arrival: 5 - 10 mins"

        btnBackHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}