package com.nikhil.rickandmorty.data.remote.service.character.list

import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto

interface CharacterListRemoteService {
   suspend fun getCharacterList():CharacterListDto
}