package com.nikhil.rickandmorty.data.remote.dto.characters.list

import com.nikhil.rickandmorty.data.local.db.characters.list.CharacterInfoEntity
import java.io.IOException

data class CharacterInfo(
    val count: Int,
    val next: String?,
    val pages: Int,
    val prev: String?
)

fun CharacterInfo.toEntity(): CharacterInfoEntity {
    return CharacterInfoEntity(
        count = count,
        next = next,
        pages = pages,
        prev = prev
    )
}

