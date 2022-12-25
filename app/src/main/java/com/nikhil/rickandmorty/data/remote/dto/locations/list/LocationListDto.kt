package com.nikhil.rickandmorty.data.remote.dto.locations.list

import com.google.gson.annotations.SerializedName

data class LocationListDto(
    @SerializedName("info")
    val info: LocationInfo,
    @SerializedName("results")
    val results: List<LocationResult>
)