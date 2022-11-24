package com.myu.myumoviepagin3.data.entities

data class MovieResponse(
    val Response: String,
    val Search: List<Movie>,
    val totalResults: String
)