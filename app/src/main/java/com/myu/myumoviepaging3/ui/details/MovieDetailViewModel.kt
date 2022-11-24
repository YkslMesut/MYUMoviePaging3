package com.myu.myumoviepaging3.ui.details

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import androidx.paging.liveData
import com.myu.myumoviepaging3.data.entities.MovieDetailResponse
import com.myu.myumoviepaging3.data.remote.MovieService
import com.myu.myumoviepaging3.data.repository.MovieRepository
import com.myu.myumoviepaging3.ui.movie.MoviePaging
import com.myu.myumoviepaging3.utils.Events
import com.myu.myumoviepaging3.utils.Result
import com.myu.myumoviepaging3.utils.Status
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(
   val api : MovieService,
   val repository: MovieRepository
) : ViewModel() {
    private val _movieDetails = MutableLiveData<Events<Result<MovieDetailResponse>>>()
    val movieDetails : LiveData<Events<Result<MovieDetailResponse>>>
    get() = _movieDetails

    fun getMovieDetails(imdbId : String) = viewModelScope.launch {
        _movieDetails.postValue(Events(Result(Status.LOADING,null,null)))
        _movieDetails.postValue(Events(repository.getMovieDetails(imdbId)))
    }
}