package com.example.estudioandroid.exampleapp.data.remote.home

import com.example.estudioandroid.exampleapp.data.model.Characters
import com.example.estudioandroid.exampleapp.data.model.Villages
import com.example.estudioandroid.exampleapp.data.remote.WebService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HomeDataSource @Inject constructor(private val webService: WebService) {

    suspend fun getCharacters(): Flow<Characters> = flow {
        emit(webService.getCharacters())
    }

    suspend fun getVillages(): Flow<Villages> = flow {
        emit(webService.getVillages())
    }

}