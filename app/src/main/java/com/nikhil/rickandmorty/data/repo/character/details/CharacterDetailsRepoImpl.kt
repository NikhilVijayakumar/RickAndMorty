package com.nikhil.rickandmorty.data.repo.character.details

import com.nikhil.rickandmorty.data.local.service.character.details.CharacterDetailsLocalService
import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto
import com.nikhil.rickandmorty.data.remote.service.character.details.CharacterDetailsRemoteService
import com.nikhil.rickandmorty.data.repo.commons.RepoStatus
import com.nikhil.rickandmorty.data.repo.commons.ResponseHandler
import javax.inject.Inject

class CharacterDetailsRepoImpl @Inject constructor(
    private val localService: CharacterDetailsLocalService,
    private val remoteService: CharacterDetailsRemoteService,
    private val responseHandler: ResponseHandler
) : CharacterDetailsRepo {
    override suspend fun getCharacterDetails(id: Int): RepoStatus<CharacterDetailsDto> {
        return try {
            if (localService.isEmpty(id)) {
                localService.insert(remoteService.getCharacterDetails(id))
            }
            responseHandler.handleSuccess(localService.getCharacterDetails(id))

        } catch (e: Exception) {
            responseHandler.handleException(e)
        }

    }
}