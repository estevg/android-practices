package com.example.estudioandroid.exampleapp.data.model

data class Characters(
    val characters: List<Character>,
    val currentPage: Int,
    val pageSize: Int,
    val total: Int
)