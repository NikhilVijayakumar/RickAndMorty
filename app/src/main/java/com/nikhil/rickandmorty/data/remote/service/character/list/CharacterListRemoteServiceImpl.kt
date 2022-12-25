package com.nikhil.rickandmorty.data.remote.service.character.list

import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.remote.service.RickAndMortyAPI
import javax.inject.Inject

class CharacterListRemoteServiceImpl @Inject constructor(private val api:RickAndMortyAPI):CharacterListRemoteService {
    override suspend fun getCharacterList(): CharacterListDto = api.getAllCharacters()
}