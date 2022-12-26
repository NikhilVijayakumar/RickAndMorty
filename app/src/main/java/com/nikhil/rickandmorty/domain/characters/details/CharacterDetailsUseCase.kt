package com.nikhil.rickandmorty.domain.characters.details

import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.repo.commons.RepoStatus

interface CharacterDetailsUseCase {
   suspend operator fun invoke(id:Int): RepoStatus<CharacterDetailsDto>
}