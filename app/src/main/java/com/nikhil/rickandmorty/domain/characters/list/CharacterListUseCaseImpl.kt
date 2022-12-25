package com.nikhil.rickandmorty.domain.characters.list

import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.repo.character.list.CharacterListRepo
import com.nikhil.rickandmorty.data.repo.commons.RepoStatus
import javax.inject.Inject

class CharacterListUseCaseImpl @Inject constructor(private val repo: CharacterListRepo) : CharacterListUseCase {
    override suspend fun invoke(): RepoStatus<CharacterListDto> = repo.getCharacterList()
}