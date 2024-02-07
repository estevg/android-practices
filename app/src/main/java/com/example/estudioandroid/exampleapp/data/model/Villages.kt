package com.example.estudioandroid.exampleapp.data.model

data class Villages(
    val currentPage: Int,
    val pageSize: Int,
    val total: Int,
    val villages: List<Village>
)