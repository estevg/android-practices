package com.example.estudioandroid.exampleapp.data.repositories.home

import com.example.estudioandroid.exampleapp.data.model.Characters
import com.example.estudioandroid.exampleapp.data.model.Villages
import kotlinx.coroutines.flow.Flow

interface HomeRepository {
    suspend fun getCharacters(): Flow<Characters>
    suspend fun getVillages(): Flow<Villages>
}