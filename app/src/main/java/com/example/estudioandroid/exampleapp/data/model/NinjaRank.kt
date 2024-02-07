package com.example.estudioandroid.exampleapp.data.model

import com.google.gson.annotations.SerializedName

data class NinjaRank(
    @SerializedName("Blank Period")
    val blankPeriod: String,
    val Gaiden: String,
    @SerializedName("Part I")
    val partI: String,
    @SerializedName("Part II")
    val partII: String
)