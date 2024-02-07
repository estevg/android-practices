package com.example.estudioandroid.exampleapp.data.model

import com.google.gson.annotations.SerializedName

data class Age(
    @SerializedName("Academy Graduate")
    val academyGraduate: String,
    @SerializedName("Blank Period")
    val blankPeriod: String,
    @SerializedName("Boruto Manga")
    val borutoManga: String,
    @SerializedName("Boruto Movie")
    val borutoMovie: String,
    @SerializedName("Chunin Promotion")
    val chuninPromotion: String,
    @SerializedName("Part I")
    val partI: String,
    @SerializedName("Part II")
    val partII: String
)