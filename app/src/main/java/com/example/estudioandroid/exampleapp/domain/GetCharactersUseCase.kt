package com.example.estudioandroid.exampleapp.domain

import com.example.estudioandroid.exampleapp.data.model.Characters
import com.example.estudioandroid.exampleapp.data.repositories.home.HomeRepositoryImpl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCharactersUseCase @Inject constructor(private val homeRepositoryImpl: HomeRepositoryImpl) {

    suspend operator fun invoke(): Flow<Characters> = homeRepositoryImpl.getCharacters()
}