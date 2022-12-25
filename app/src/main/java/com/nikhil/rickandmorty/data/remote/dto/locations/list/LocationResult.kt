package com.nikhil.rickandmorty.data.remote.dto.locations.list

data class LocationResult(
    val created: String,
    val dimension: String,
    val id: Int,
    val name: String,
    val residents: List<String>,
    val type: String,
    val url: String
)