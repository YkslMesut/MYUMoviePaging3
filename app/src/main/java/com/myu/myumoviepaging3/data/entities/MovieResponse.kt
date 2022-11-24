package com.myu.myumoviepaging3.data.entities

data class MovieResponse(
    val Response: String,
    val Search: List<Movie>,
    val totalResults: String
)