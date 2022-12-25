package com.nikhil.rickandmorty.data.local.service.character.list

import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto

interface CharacterListLocalService {
   suspend fun isEmpty():Boolean
    suspend fun insert(dto:CharacterListDto)
    suspend fun getCharacterList():CharacterListDto
}