package com.nikhil.rickandmorty.data.remote.dto.locations.list

data class LocationInfo(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)