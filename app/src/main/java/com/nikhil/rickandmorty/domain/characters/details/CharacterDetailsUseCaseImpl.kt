package com.nikhil.rickandmorty.domain.characters.details

import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.repo.character.details.CharacterDetailsRepo
import com.nikhil.rickandmorty.data.repo.character.details.CharacterDetailsRepoImpl
import com.nikhil.rickandmorty.data.repo.character.list.CharacterListRepo
import com.nikhil.rickandmorty.data.repo.commons.RepoStatus
import javax.inject.Inject

class CharacterDetailsUseCaseImpl @Inject constructor(private val repo: CharacterDetailsRepo) : CharacterDetailsUseCase {
    override suspend fun invoke(id:Int): RepoStatus<CharacterDetailsDto> = repo.getCharacterDetails(id)
}