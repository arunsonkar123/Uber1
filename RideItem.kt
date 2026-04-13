package com.example.ubercloneapp

data class RideItem(
    val serviceName: String,
    val pickup: String,
    val drop: String,
    val fare: String,
    val paymentMode: String
)