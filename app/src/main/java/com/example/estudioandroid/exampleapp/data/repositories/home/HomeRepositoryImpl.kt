package com.example.estudioandroid.exampleapp.data.repositories.home

import com.example.estudioandroid.exampleapp.data.model.Characters
import com.example.estudioandroid.exampleapp.data.model.Villages
import com.example.estudioandroid.exampleapp.data.remote.home.HomeDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepositoryImpl @Inject constructor(private val dataSource: HomeDataSource) :
    HomeRepository {

    override suspend fun getCharacters(): Flow<Characters> = dataSource.getCharacters()

    override suspend fun getVillages(): Flow<Villages> = dataSource.getVillages()
}