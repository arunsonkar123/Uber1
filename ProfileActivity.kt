package com.example.ubercloneapp

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {

    private lateinit var tvName: TextView
    private lateinit var tvUsername: TextView
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        tvName = findViewById(R.id.tvName)
        tvUsername = findViewById(R.id.tvUsername)

        sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE)

        val name = sharedPreferences.getString("name", "User")
        val username = sharedPreferences.getString("username", "Username")

        tvName.text = "Name: $name"
        tvUsername.text = "Username: $username"
    }
}