package com.myu.myumoviepaging3.data.repository

import com.myu.myumoviepaging3.data.entities.MovieDetailResponse
import com.myu.myumoviepaging3.data.remote.MovieService
import com.myu.myumoviepaging3.utils.Constants
import com.myu.myumoviepaging3.utils.Status

class MovieRepository(
    private val api : MovieService
) {
    suspend fun getMovieDetails(imdbId:String) : com.myu.myumoviepaging3.utils.Result<MovieDetailResponse>{
        return try {
            val response = api.getMovieDetails(imdbId,Constants.API_KEY)
            if (response.isSuccessful){
                com.myu.myumoviepaging3.utils.Result(Status.SUCCESS,response.body(),null)

            } else {
                com.myu.myumoviepaging3.utils.Result(Status.ERROR,null,null)

            }
        } catch (e : Exception) {
            com.myu.myumoviepaging3.utils.Result(Status.ERROR,null,null)
        }
    }
}