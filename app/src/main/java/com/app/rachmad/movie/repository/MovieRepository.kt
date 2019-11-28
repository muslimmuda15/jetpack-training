package com.app.rachmad.movie.repository

import androidx.lifecycle.MutableLiveData
import com.app.rachmad.movie.`object`.*
import com.app.rachmad.movie.helper.Utils

class MovieRepository{
    var movieData = MutableLiveData<List<MovieData>>()
    var tvData = MutableLiveData<List<TvData>>()
    var genreList = MutableLiveData<List<GenreData>>()

    fun movie(){
        movieData.value = Utils.getMovieArray()
    }

    fun tv(){
        tvData.value = Utils.getTvArray()
    }

    fun genre(){
        genreList.value = Utils.getGenreArray()
    }
}