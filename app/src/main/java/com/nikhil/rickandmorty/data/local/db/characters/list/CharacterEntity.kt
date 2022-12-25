package com.nikhil.rickandmorty.data.local.db.characters.list

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterLocation
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterOrigin
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterResult
import java.lang.reflect.Type


@Entity(tableName = "character")
data class CharacterEntity(
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

fun  CharacterEntity.toDto():CharacterResult{
    val gson = Gson()
    val listType: Type = object : TypeToken<List<String?>?>() {}.type
    val locationData: CharacterLocation = gson.fromJson(location, CharacterLocation::class.java)
    val originData: CharacterOrigin = gson.fromJson(origin, CharacterOrigin::class.java)
    val episodeData: List<String> =  gson.fromJson(episode, listType);
    return CharacterResult(
        created = created,
        episode = episodeData,
        gender = gender,
        id = id,
        image = image,
        location = locationData,
        name = name,
        origin =originData ,
        species = species,
        status = status,
        type =type,
        url = url
    )
}