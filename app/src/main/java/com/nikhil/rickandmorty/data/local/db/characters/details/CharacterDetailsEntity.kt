package com.nikhil.rickandmorty.data.local.db.characters.details

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto
import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsLocation
import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsOrigin
import java.lang.reflect.Type

@Entity(tableName = "character_details")
data class CharacterDetailsEntity(
    val created: String,
    val episode: String,
    val gender: String,
    @PrimaryKey
    val id: Int,
    val image: String,
    val location: String,
    val name: String,
    val origin: String,
    val species: String,
    val status: String,
    val type: String,
    val url: String
)

fun CharacterDetailsEntity.toDto(): CharacterDetailsDto {
    val gson = Gson()
    val listType: Type = object : TypeToken<List<String?>?>() {}.type
    val locationData: CharacterDetailsLocation =
        gson.fromJson(location, CharacterDetailsLocation::class.java)
    val originData: CharacterDetailsOrigin =
        gson.fromJson(origin, CharacterDetailsOrigin::class.java)
    val episodeData: List<String> = gson.fromJson(episode, listType)
    return CharacterDetailsDto(
        created = created,
        episode = episodeData,
        gender = gender,
        id = id,
        image = image,
        location = locationData,
        name = name,
        origin = originData,
        species = species,
        status = status,
        type = type,
        url = url
    )
}
