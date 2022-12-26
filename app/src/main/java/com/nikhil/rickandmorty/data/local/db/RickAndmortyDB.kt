package com.nikhil.rickandmorty.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nikhil.rickandmorty.data.local.db.characters.details.CharacterDetailsDoa
import com.nikhil.rickandmorty.data.local.db.characters.details.CharacterDetailsEntity
import com.nikhil.rickandmorty.data.local.db.characters.list.CharacterDoa
import com.nikhil.rickandmorty.data.local.db.characters.list.CharacterEntity
import com.nikhil.rickandmorty.data.local.db.characters.list.CharacterInfoDoa
import com.nikhil.rickandmorty.data.local.db.characters.list.CharacterInfoEntity

@Database(entities = [CharacterEntity::class,CharacterInfoEntity::class, CharacterDetailsEntity::class], version = 1)
abstract class RickAndMortyDB : RoomDatabase() {
    abstract fun getCharacterDoa(): CharacterDoa
    abstract fun getCharacterInfoDoa():CharacterInfoDoa
    abstract fun getCharacterDetailsDoa(): CharacterDetailsDoa
}