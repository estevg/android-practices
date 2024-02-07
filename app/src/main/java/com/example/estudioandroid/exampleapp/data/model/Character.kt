package com.example.estudioandroid.exampleapp.data.model

data class Character(
    val debut: Debut,
    val family: Family,
    val id: Int,
    val images: List<String>,
    val jutsu: List<String>,
    val name: String,
    val natureType: List<String>,
    val personal: Personal,
    val rank: Rank,
    val tools: List<String>,
    val uniqueTraits: List<String>,
    val voiceActors: VoiceActors
)