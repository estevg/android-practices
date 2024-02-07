package com.example.estudioandroid.exampleapp.data.model

import com.google.gson.annotations.SerializedName

data class Weight(
    @SerializedName("Part I")
    val partI: String,
    @SerializedName("Part II")
    val partII: String
)