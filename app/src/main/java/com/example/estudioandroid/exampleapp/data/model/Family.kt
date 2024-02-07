package com.example.estudioandroid.exampleapp.data.model

import com.google.gson.annotations.SerializedName

data class Family(
    @SerializedName("adoptive brother")
    val adoptiveBrother: String,
    @SerializedName("adoptive mother")
    val adoptiveMother: String,
    @SerializedName("adoptive son")
    val adoptiveSon: String,
    @SerializedName("adoptive sons")
    val adoptiveSons: String,
    val aunt: String,
    val brother: String,
    val clone: String,
    @SerializedName("clone/brother")
    val cloneBrother: String,
    @SerializedName("clone/son")
    val cloneSon: String,
    val cousin: String,
    val creator: String,
    val daughter: String,
    val father: String,
    @SerializedName("first cousin once removed")
    val firstCousin: String,
    @SerializedName("genetic template")
    val geneticTemplate: String,
    @SerializedName("genetic template/parent")
    val geneticTemplateParent: String,
    val godfather: String,
    val godson: String,
    val granddaughter: String,
    val grandmother: String,
    val grandson: String,
    val granduncle: String,
    @SerializedName("great-grandfather")
    val greatGrandfather: String,
    val host: String,
    val lover: String,
    val mother: String,
    val nephew: String,
    val niece: String,
    val pet: String,
    val sister: String,
    val son: String,
    val uncle: String,
    val wife: String
)