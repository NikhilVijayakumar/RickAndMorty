package com.nikhil.rickandmorty.data.local.service.character.list

import com.nikhil.rickandmorty.data.local.RickAndMortyDB
import com.nikhil.rickandmorty.data.local.db.characters.list.CharacterDoa
import com.nikhil.rickandmorty.data.local.db.characters.list.CharacterInfoDoa
import com.nikhil.rickandmorty.data.local.db.characters.list.toDto
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterResult
import com.nikhil.rickandmorty.data.remote.dto.characters.list.toEntity
import javax.inject.Inject

class CharacterListLocalServiceImpl @Inject constructor(val db: RickAndMortyDB) :
    CharacterListLocalService {
    private val characterDoa: CharacterDoa = db.getCharacterDoa()
    private val characterInfoDoa: CharacterInfoDoa = db.getCharacterInfoDoa()

    override suspend fun isEmpty(): Boolean = db.getCharacterDoa().getCount() <= 0

    override suspend fun insert(dto: CharacterListDto) {
        dto.results.forEach {
            characterDoa.insertAll(it.toEntity())
        }
        characterInfoDoa.insert(dto.info.toEntity())
    }

    override suspend fun getCharacterList(): CharacterListDto {
        val characterList: MutableList<CharacterResult> = mutableListOf()
        characterDoa.getAllCharacters().forEach {
            characterList.add(it.toDto())
        }
        val characterInfo = characterInfoDoa.getCharacterInfo()
        return CharacterListDto(
            info = characterInfo.toDto(),
            results = characterList

        )
    }
}