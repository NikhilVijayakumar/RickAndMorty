package com.nikhil.rickandmorty.domain.characters.list

import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.repo.commons.RepoStatus

interface CharacterListUseCase {
   suspend operator fun invoke(): RepoStatus<CharacterListDto>
}