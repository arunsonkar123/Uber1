package com.example.ubercloneapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView

class ServicesActivity : AppCompatActivity() {

    private lateinit var recyclerServices: RecyclerView
    private lateinit var bottomNavigationView: BottomNavigationView
    private lateinit var bannerImage: ImageView
    private lateinit var tvBannerButton: TextView
    private lateinit var bookOtherCard: CardView
    private lateinit var tvSelectedService: TextView
    private lateinit var btnContinue: Button
    private lateinit var etPickup: EditText
    private lateinit var etDrop: EditText

    private var selectedService: String = "Trip"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_services)

        recyclerServices = findViewById(R.id.recyclerServices)
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bannerImage = findViewById(R.id.bannerImage)
        tvBannerButton = findViewById(R.id.tvBannerButton)
        bookOtherCard = findViewById(R.id.bookOtherCard)
        tvSelectedService = findViewById(R.id.tvSelectedService)
        btnContinue = findViewById(R.id.btnContinue)
        etPickup = findViewById(R.id.etPickup)
        etDrop = findViewById(R.id.etDrop)

        bannerImage.setImageResource(R.drawable.banner_map)

        val serviceList = listOf(
            ServiceItem("Trip", R.drawable.car, "100%"),
            ServiceItem("Bike", R.drawable.bike, "100%"),
            ServiceItem("Intercity", R.drawable.intercity, "100%"),
            ServiceItem("Rentals", R.drawable.rental),
            ServiceItem("Bus", R.drawable.bus, "Promo"),
            ServiceItem("Parcel", R.drawable.parcel),
            ServiceItem("Reserve", R.drawable.calendar),
            ServiceItem("Metro", R.drawable.metro)
        )

        recyclerServices.layoutManager = GridLayoutManager(this, 4)
        recyclerServices.adapter = ServiceAdapter(serviceList) { item ->
            selectedService = item.title
            tvSelectedService.text = "Selected Service: ${item.title}"
        }

        tvBannerButton.setOnClickListener {
            goToBooking(selectedService)
        }

        bookOtherCard.setOnClickListener {
            goToBooking("Book for Others")
        }

        btnContinue.setOnClickListener {
            goToBooking(selectedService)
        }

        bottomNavigationView.selectedItemId = R.id.nav_services

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> {
                    startActivity(Intent(this, HomeActivity::class.java))
                    true
                }
                R.id.nav_services -> true
                R.id.nav_activity -> {
                    startActivity(Intent(this, RideHistoryActivity::class.java))
                    true
                }
                R.id.nav_account -> {
                    startActivity(Intent(this, AccountActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    private fun goToBooking(serviceName: String) {
        val pickup = etPickup.text.toString().trim()
        val drop = etDrop.text.toString().trim()

        if (pickup.isEmpty()) {
            etPickup.error = "Enter pickup location"
            return
        }

        if (drop.isEmpty()) {
            etDrop.error = "Enter destination"
            return
        }

        val intent = Intent(this, BookingActivity::class.java)
        intent.putExtra("service_name", serviceName)
        intent.putExtra("pickup", pickup)
        intent.putExtra("drop", drop)
        startActivity(intent)
    }
}