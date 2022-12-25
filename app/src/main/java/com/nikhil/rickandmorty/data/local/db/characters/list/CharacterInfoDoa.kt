package com.nikhil.rickandmorty.data.local.db.characters.list

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterInfoDoa {

    @Query("SELECT COUNT(*) FROM CHARACTER_INFO")
    fun getCount():Int

    @Query("SELECT * FROM CHARACTER_INFO LIMIT 1")
    fun getCharacterInfo():CharacterInfoEntity

    @Insert
    fun insert(characterInfoEntity: CharacterInfoEntity)

    @Delete
    fun delete(characterInfoEntity: CharacterInfoEntity)
}