package com.nikhil.rickandmorty.data.repo.character.list

import com.nikhil.rickandmorty.data.local.service.character.list.CharacterListLocalService
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.remote.service.character.list.CharacterListRemoteService
import com.nikhil.rickandmorty.data.repo.commons.RepoStatus
import com.nikhil.rickandmorty.data.repo.commons.ResponseHandler
import javax.inject.Inject

class CharacterListRepoImpl @Inject constructor(
   private val localService: CharacterListLocalService,
   private val remoteService: CharacterListRemoteService,
   private val responseHandler:ResponseHandler
) :CharacterListRepo {
    override suspend fun getCharacterList(): RepoStatus<CharacterListDto> {
        return try{
            if (localService.isEmpty()) {
                localService.insert(remoteService.getCharacterList())
            }
            responseHandler.handleSuccess( localService.getCharacterList())

        }catch (e:Exception){
            responseHandler.handleException(e)
        }

    }
}