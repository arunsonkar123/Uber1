package com.example.ubercloneapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class DestinationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination)

        val etFrom = findViewById<EditText>(R.id.etFrom)
        val etTo = findViewById<EditText>(R.id.etTo)
        val btnContinueDestination = findViewById<Button>(R.id.btnContinueDestination)

        etFrom.setText("Current Location")

        btnContinueDestination.setOnClickListener {
            val from = etFrom.text.toString().trim()
            val to = etTo.text.toString().trim()

            val intent = Intent(this, ServicesActivity::class.java)
            intent.putExtra("from_location", from)
            intent.putExtra("to_location", to)
            startActivity(intent)
        }
    }
}