package com.nikhil.rickandmorty.data.repo.character.details

import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.repo.commons.RepoStatus

interface CharacterDetailsRepo {
    suspend fun getCharacterDetails(id:Int): RepoStatus<CharacterDetailsDto>
}