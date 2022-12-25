package com.nikhil.rickandmorty.data.repo.character.list

import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.repo.commons.RepoStatus

interface CharacterListRepo {
    suspend fun getCharacterList(): RepoStatus<CharacterListDto>
}