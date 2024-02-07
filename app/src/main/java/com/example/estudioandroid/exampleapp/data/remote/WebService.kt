package com.example.estudioandroid.exampleapp.data.remote

import com.example.estudioandroid.exampleapp.data.model.Characters
import com.example.estudioandroid.exampleapp.data.model.Villages
import retrofit2.http.GET

interface WebService {

    @GET("characters")
    suspend fun getCharacters(): Characters

    @GET("villages")
    suspend fun getVillages(): Villages


}