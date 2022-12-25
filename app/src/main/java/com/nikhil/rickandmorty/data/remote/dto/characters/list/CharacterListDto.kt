package com.nikhil.rickandmorty.data.remote.dto.characters.list

import com.google.gson.annotations.SerializedName
import com.nikhil.rickandmorty.data.local.db.characters.list.CharacterInfoEntity

data class CharacterListDto(
    @SerializedName("info")
    val info: CharacterInfo,
    @SerializedName("results")
    val results: List<CharacterResult>
)

