package com.example.estudioandroid.common

data class Board(
    val background: Int,
    val image: Int,
    val title: String,
    val description: String,
    val video: String = ""
)

data class BoardVideo(
    val background: Int,
    val title: String,
    val description: String,
    val video: String
)