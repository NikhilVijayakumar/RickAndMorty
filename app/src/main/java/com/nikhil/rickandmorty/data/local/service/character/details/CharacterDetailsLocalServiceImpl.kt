package com.nikhil.rickandmorty.data.local.service.character.details

import com.nikhil.rickandmorty.data.local.RickAndMortyDB
import com.nikhil.rickandmorty.data.local.db.characters.details.CharacterDetailsDoa
import com.nikhil.rickandmorty.data.local.db.characters.details.toDto
import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto
import com.nikhil.rickandmorty.data.remote.dto.characters.details.toEntity
import javax.inject.Inject

class CharacterDetailsLocalServiceImpl @Inject constructor(val db: RickAndMortyDB) :
    CharacterDetailsLocalService {

    private val doa: CharacterDetailsDoa = db.getCharacterDetailsDoa()

    override suspend fun isEmpty(id: Int): Boolean = doa.getCount(id) <= 0

    override suspend fun insert(dto: CharacterDetailsDto) {
        doa.insert(dto.toEntity())
    }

    override suspend fun getCharacterDetails(id: Int): CharacterDetailsDto {
        return doa.getCharacterDetails(id).toDto()
    }
}