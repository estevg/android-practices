package com.example.estudioandroid.exampleapp.data.model

import com.google.gson.annotations.SerializedName

data class Height(
    @SerializedName("Blank Period")
    val blankPeriod: String,
    @SerializedName("Boruto Manga")
    val borutoManga: String,
    @SerializedName("Boruto Movie")
    val borutoMovie: String,
    val Gaiden: String,
    @SerializedName("Part I")
    val partI: String,
    @SerializedName("Part II")
    val partII: String
)