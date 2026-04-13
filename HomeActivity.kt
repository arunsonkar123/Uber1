package com.example.ubercloneapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val btnOpenServices = findViewById<Button>(R.id.btnOpenServices)

        btnOpenServices.setOnClickListener {
            startActivity(Intent(this, ServicesActivity::class.java))
        }
    }
}