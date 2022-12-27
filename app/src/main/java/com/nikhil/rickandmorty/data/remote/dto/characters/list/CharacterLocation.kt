package com.nikhil.rickandmorty.data.remote.dto.characters.list

import com.nikhil.xml.story.annotation.AutoMap

@AutoMap
data class CharacterLocation(
    val name: String,
    val url: String
)