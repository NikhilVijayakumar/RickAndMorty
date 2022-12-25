package com.nikhil.rickandmorty.data.remote.service

import com.nikhil.rickandmorty.data.remote.dto.characters.details.CharacterDetailsDto
import com.nikhil.rickandmorty.data.remote.dto.characters.list.CharacterListDto
import com.nikhil.rickandmorty.data.remote.dto.episodes.details.EpisodeDto
import com.nikhil.rickandmorty.data.remote.dto.episodes.list.EpisodeListDto
import com.nikhil.rickandmorty.data.remote.dto.locations.details.LocationDto
import com.nikhil.rickandmorty.data.remote.dto.locations.list.LocationListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import java.io.IOException

interface RickAndMortyAPI {

    @GET("character")
   suspend fun getAllCharacters(): CharacterListDto

    @GET("character/{id}")
    suspend fun getCharacter(@Path("id") id: String): CharacterDetailsDto

    @GET("character/{id}")
    suspend fun getMultipleCharacters(@Path("id") id: String): List<CharacterDetailsDto>

    @GET("character")
    suspend fun getFilteredCharacters(@QueryMap map: Map<String, String>): CharacterListDto


    @GET("location")
    suspend fun getAllLocation(): LocationListDto

    @GET("location/{id}")
    suspend fun getLocation(@Path("id") id: String): LocationDto

    @GET("location/{id}")
    suspend fun getMultipleLocation(@Path("id") id: String): List<LocationDto>

    @GET("location")
    suspend fun getFilteredLocation(@QueryMap map: Map<String, String>): LocationListDto


    @GET("episode")
    suspend fun getAllEpisode(): EpisodeListDto

    @GET("episode/{id}")
    suspend fun getEpisode(@Path("id") id: String): EpisodeDto

    @GET("episode/{id}")
    suspend fun getMultipleEpisode(@Path("id") id: String): List<EpisodeDto>

    @GET("episode")
    suspend fun getFilteredEpisode(@QueryMap map: Map<String, String>): EpisodeListDto


}

