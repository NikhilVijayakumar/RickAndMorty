package com.nikhil.rickandmorty.data.local.db.characters.list

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import java.util.IllegalFormatCodePointException

@Dao
interface  CharacterDoa {

    @Query("SELECT COUNT(*) FROM CHARACTER")
    fun getCount():Int

    @Query("SELECT * FROM CHARACTER")
    fun getAllCharacters():List<CharacterEntity>

    @Insert
    fun insertAll(vararg entityList: CharacterEntity)

    @Delete
    fun delete(entity: CharacterEntity)
}