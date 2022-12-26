package com.nikhil.rickandmorty.data.remote.service.character.details

import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.remote.service.RickAndMortyAPI
import javax.inject.Inject

class CharacterDetailsRemoteServiceImpl @Inject constructor(private val api:RickAndMortyAPI):CharacterDetailsRemoteService {
    override suspend fun getCharacterDetails(id:Int): CharacterDetailsDto = api.getCharacter(id)
}