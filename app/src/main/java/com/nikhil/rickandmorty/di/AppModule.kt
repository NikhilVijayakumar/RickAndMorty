package com.nikhil.rickandmorty.di

import android.content.Context
import androidx.room.Room
import com.nikhil.rickandmorty.data.local.RickAndMortyDB
import com.nikhil.rickandmorty.data.remote.service.RickAndMortyAPI
import com.nikhil.rickandmorty.data.repo.commons.ResponseHandler
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object  AppModule {

    val BASE_URL = "https://rickandmortyapi.com/api/"
    val DB_NAME = "RickAndMorty"

    @Singleton
    @Provides
    fun provideRickAndMortyApi(): RickAndMortyAPI {

        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient
            .Builder()
            .addInterceptor(interceptor)
            .build()

        return Retrofit
            .Builder()
            .client(client)
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RickAndMortyAPI::class.java)
    }
    @Singleton
    @Provides
    fun provideRickAndMortyDB(@ApplicationContext appContext: Context):RickAndMortyDB = Room.databaseBuilder(
        appContext,
        RickAndMortyDB::class.java,
        DB_NAME
    ).build()

    @Singleton
    @Provides
    fun provideResponseHandler() = ResponseHandler()

}


