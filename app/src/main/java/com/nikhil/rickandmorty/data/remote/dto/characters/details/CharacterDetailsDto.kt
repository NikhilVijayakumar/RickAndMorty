package com.nikhil.rickandmorty.data.remote.dto.characters.details

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikhil.rickandmorty.data.local.db.characters.details.CharacterDetailsEntity
import java.lang.reflect.Type

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

fun CharacterDetailsDto.toEntity(): CharacterDetailsEntity {
    val gson = Gson()
    val locationJson = gson.toJson(location)
    val originJson = gson.toJson(origin)
    val listType: Type = object : TypeToken<List<String?>?>() {}.type
    val episodeJson: String = gson.toJson(episode, listType)
    return CharacterDetailsEntity(
        created = created,
        episode = episodeJson,
        gender = gender,
        id = id,
        image = image,
        location = locationJson,
        name = name,
        origin = originJson,
        species = species,
        status = status,
        type = type,
        url = url
    )
}