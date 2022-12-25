package com.nikhil.rickandmorty.data.remote.dto.characters.list

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikhil.rickandmorty.data.local.db.characters.list.CharacterEntity
import java.lang.reflect.Type
import java.util.*


data class CharacterResult(
    val created: String,
    val episode: List<String>,
    val gender: String,
    val id: Int,
    val image: String,
    val location: CharacterLocation,
    val name: String,
    val origin: CharacterOrigin,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterResult.toEntity():CharacterEntity {
    val gson = Gson()
    val locationJson = gson.toJson(location)
    val originJson = gson.toJson(origin)
    val listType: Type = object : TypeToken<List<String?>?>() {}.type
    val episodeJson: String = gson.toJson(episode, listType)
    return CharacterEntity(
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
    //val episodeJson = gson.fromJson<List<String>>(json, listType)
}