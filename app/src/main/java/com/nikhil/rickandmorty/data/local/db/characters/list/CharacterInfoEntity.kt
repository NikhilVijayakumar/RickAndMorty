package com.nikhil.rickandmorty.data.local.db.characters.list

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterInfo

@Entity(tableName = "character_info")
data class CharacterInfoEntity(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 1
)

fun CharacterInfoEntity.toDto():CharacterInfo = CharacterInfo(
    count = count,
    next = next,
    pages = pages,
    prev = prev
)