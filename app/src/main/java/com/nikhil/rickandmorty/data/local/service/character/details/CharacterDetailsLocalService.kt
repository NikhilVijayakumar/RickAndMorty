package com.nikhil.rickandmorty.data.local.service.character.details

import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto

interface CharacterDetailsLocalService {
    suspend fun isEmpty(id: Int): Boolean
    suspend fun insert(dto: CharacterDetailsDto)
    suspend fun getCharacterDetails(id:Int): CharacterDetailsDto
}