package com.example.ubercloneapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etPhone: EditText
    private lateinit var btnContinue: Button
    private lateinit var btnGoogle: Button
    private lateinit var btnEmail: Button
    private lateinit var btnFindAccount: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etPhone = findViewById(R.id.etPhone)
        btnContinue = findViewById(R.id.btnContinue)
        btnGoogle = findViewById(R.id.btnGoogle)
        btnEmail = findViewById(R.id.btnEmail)
        btnFindAccount = findViewById(R.id.btnFindAccount)

        btnContinue.setOnClickListener {
            val phone = etPhone.text.toString().trim()
            if (phone.isEmpty()) {
                Toast.makeText(this, "Enter mobile number", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, HomeActivity::class.java))
            }
        }

        btnGoogle.setOnClickListener {
            Toast.makeText(this, "Google sign-in demo", Toast.LENGTH_SHORT).show()
        }

        btnEmail.setOnClickListener {
            Toast.makeText(this, "Email sign-in demo", Toast.LENGTH_SHORT).show()
        }

        btnFindAccount.setOnClickListener {
            Toast.makeText(this, "Find account demo", Toast.LENGTH_SHORT).show()
        }
    }
}