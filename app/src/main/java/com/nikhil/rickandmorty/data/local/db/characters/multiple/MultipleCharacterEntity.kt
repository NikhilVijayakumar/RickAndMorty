package com.nikhil.rickandmorty.data.local.db.characters.multiple

import androidx.room.Entity

@Entity(tableName = "multiple_character")
data class MultipleCharacterEntity(
    val created: String,
    val episode: List<String>,
    val gender: String,
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