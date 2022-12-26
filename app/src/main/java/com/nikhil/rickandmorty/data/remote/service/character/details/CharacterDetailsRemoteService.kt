package com.nikhil.rickandmorty.data.remote.service.character.details

import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto

interface CharacterDetailsRemoteService {
    suspend fun getCharacterDetails(id:Int): CharacterDetailsDto
}