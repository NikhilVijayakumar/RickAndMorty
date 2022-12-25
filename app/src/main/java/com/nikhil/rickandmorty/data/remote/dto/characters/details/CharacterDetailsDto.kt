package com.nikhil.rickandmorty.data.remote.dto.characters.details

data class CharacterDetailsDto(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterDetailsLocation,
    val name: String,
    val origin: CharacterDetailsOrigin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)