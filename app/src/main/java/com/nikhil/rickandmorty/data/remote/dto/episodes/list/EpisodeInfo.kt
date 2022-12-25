package com.nikhil.rickandmorty.data.remote.dto.episodes.list

data class EpisodeInfo(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: Any
)