package com.nikhil.rickandmorty.data.remote.dto.episodes.list

import com.google.gson.annotations.SerializedName

data class EpisodeListDto(
    @SerializedName("info")
    val info: EpisodeInfo,
    @SerializedName("results")
    val results: List<EpisodeResult>
)