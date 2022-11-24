package com.myu.myumoviepaging3.data.remote

import com.myu.myumoviepaging3.data.entities.MovieDetailResponse
import com.myu.myumoviepaging3.data.entities.MovieResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {

    @GET("/")
    suspend fun getAllMovies(
        @Query("s") s: String,
        @Query("page") page: Int,
        @Query("apiKey") apiKey: String,
    ) : Response<MovieResponse>

    @GET("/")
    suspend fun getMovieDetails(
        @Query("i") imdbId: String,
        @Query("apiKey") apiKey: String,
    ) : Response<MovieDetailResponse>
}