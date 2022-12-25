package com.nikhil.rickandmorty.di

import com.nikhil.rickandmorty.data.local.service.character.list.CharacterListLocalService
import com.nikhil.rickandmorty.data.local.service.character.list.CharacterListLocalServiceImpl
import com.nikhil.rickandmorty.data.remote.service.character.list.CharacterListRemoteService
import com.nikhil.rickandmorty.data.remote.service.character.list.CharacterListRemoteServiceImpl
import com.nikhil.rickandmorty.data.repo.character.list.CharacterListRepo
import com.nikhil.rickandmorty.data.repo.character.list.CharacterListRepoImpl
import com.nikhil.rickandmorty.domain.characters.list.CharacterListUseCase
import com.nikhil.rickandmorty.domain.characters.list.CharacterListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterListModule {

    @Binds
   abstract fun bindCharacterListUseCase(useCaseImpl: CharacterListUseCaseImpl): CharacterListUseCase

    @Binds
    abstract fun bindCharacterRepo(repo: CharacterListRepoImpl):CharacterListRepo

    @Binds
    abstract fun bindCharacterLocalService(localService: CharacterListLocalServiceImpl):CharacterListLocalService

    @Binds
    abstract fun bindCharacterRemoteService(remoteService: CharacterListRemoteServiceImpl):CharacterListRemoteService


}