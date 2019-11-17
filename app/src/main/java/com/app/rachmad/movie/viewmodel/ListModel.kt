package com.app.rachmad.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.app.rachmad.movie.MainActivity
import com.app.rachmad.movie.`object`.*
import com.app.rachmad.movie.repository.MovieRepository

class ListModel: ViewModel(){
    val movieRepository: MovieRepository = MovieRepository()

    fun movie() = movieRepository.movie()
    fun getMovieData(): MovieBaseData? = movieRepository.movieData

    fun tv() = movieRepository.tv()
    fun getTvData(): TvBaseData? = movieRepository.tvData

    fun genre() = movieRepository.genre()
    fun getGenreList(): List<GenreData> = movieRepository.genreList
}