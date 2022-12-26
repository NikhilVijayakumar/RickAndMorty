package com.nikhil.rickandmorty.di

import com.nikhil.rickandmorty.data.local.service.character.details.CharacterDetailsLocalService
import com.nikhil.rickandmorty.data.local.service.character.details.CharacterDetailsLocalServiceImpl
import com.nikhil.rickandmorty.data.remote.service.character.details.CharacterDetailsRemoteService
import com.nikhil.rickandmorty.data.remote.service.character.details.CharacterDetailsRemoteServiceImpl
import com.nikhil.rickandmorty.data.repo.character.details.CharacterDetailsRepo
import com.nikhil.rickandmorty.data.repo.character.details.CharacterDetailsRepoImpl
import com.nikhil.rickandmorty.domain.characters.details.CharacterDetailsUseCase
import com.nikhil.rickandmorty.domain.characters.details.CharacterDetailsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class CharacterDetailsModule {

    @Binds
    abstract fun bindCharacterDetailsUseCase(useCaseImpl: CharacterDetailsUseCaseImpl): CharacterDetailsUseCase

    @Binds
    abstract fun bindCharacterDetailsRepo(repo: CharacterDetailsRepoImpl): CharacterDetailsRepo

    @Binds
    abstract fun bindCharacterLocalService(localService: CharacterDetailsLocalServiceImpl): CharacterDetailsLocalService

    @Binds
    abstract fun bindCharacterRemoteService(remoteService: CharacterDetailsRemoteServiceImpl): CharacterDetailsRemoteService


}