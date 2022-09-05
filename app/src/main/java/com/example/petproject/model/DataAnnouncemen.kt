package com.example.petproject.model

data class DataAnnouncement(
    val id: Int,
    val petType: String,
    val imageUrl: String,
    val title: String,
    val description: String,
    val geoPosition: GeoPosition
)

data class GeoPosition(
    val lat: Double,
    val lng: Double
)