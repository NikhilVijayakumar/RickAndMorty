package com.nikhil.rickandmorty.data.local.db.characters.details

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CharacterDetailsDoa {
    @Query("SELECT COUNT(*) FROM character_details WHERE :id = id")
    fun getCount(id:Int): Int

    @Query("SELECT * FROM character_details WHERE :id = id")
    fun getCharacterDetails(id:Int): CharacterDetailsEntity

    @Insert
    fun insert(entity: CharacterDetailsEntity)

    @Delete
    fun delete(entity: CharacterDetailsEntity)
}