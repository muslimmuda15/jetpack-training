package com.app.rachmad.movie.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.DataSource
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.app.rachmad.movie.MainActivity
import com.app.rachmad.movie.`object`.*
import com.app.rachmad.movie.repository.MovieRepository
import com.app.rachmad.movie.sqlite.model.FavoriteModel

class ListModel: ViewModel(){
    val movieRepository: MovieRepository = MovieRepository()
    val favoriteModel: FavoriteModel = FavoriteModel(MainActivity.context)

    fun movie() = movieRepository.movie()
    fun getMovieData(): LiveData<List<MovieData>> = movieRepository.movieData

    fun tv() = movieRepository.tv()
    fun getTvData(): LiveData<List<TvData>> = movieRepository.tvData

    fun genre() = movieRepository.genre()
    fun getGenreList(): LiveData<List<GenreData>> = movieRepository.genreList

    val movieFavoriteLiveData: LiveData<PagedList<MovieDataFavorite>>
    val tvFavoriteLiveData: LiveData<PagedList<TvDataFavorite>>

    init {
        val movieFactory: DataSource.Factory<Int, MovieDataFavorite>? = favoriteModel.getFavoriteMovieList()
        val moviePagedBuilder: LivePagedListBuilder<Int, MovieDataFavorite> = LivePagedListBuilder(movieFactory!!, 20)
        movieFavoriteLiveData = moviePagedBuilder.build()

        val tvFactory: DataSource.Factory<Int, TvDataFavorite>? = favoriteModel.getFavoriteTvList()
        val tvPagedBuilder: LivePagedListBuilder<Int, TvDataFavorite> = LivePagedListBuilder(tvFactory!!, 20)
        tvFavoriteLiveData = tvPagedBuilder.build()
    }

    fun insertMovieFavorite(movieData: MovieDataFavorite) = favoriteModel.insertMovieFavorite(movieData)
    fun insertTvFavorite(tvData: TvDataFavorite) = favoriteModel.insertTvFavorite(tvData)
    fun countAllFavoriteMovie(): Int = favoriteModel.countAllFavoriteMovie()
    fun countAllFavoriteTv(): Int = favoriteModel.countAllFavoriteTv()
    fun countFavoritedMovieLive(id: Int): LiveData<Int> = favoriteModel.countFavoritedMovieLive(id)
    fun countFavoritedTvLive(id: Int): LiveData<Int> = favoriteModel.countFavoritedTvLive(id)
    fun deleteMovieFavorite(movieData: MovieDataFavorite) = favoriteModel.deleteMovieFavorite(movieData)
    fun deleteTvFavorite(tvData: TvDataFavorite) = favoriteModel.deleteTvFavorite(tvData)
    fun isFavoritedMovie(id: Int): Boolean = favoriteModel.isFavoritedMovie(id)
    fun isFavoritedTv(id: Int): Boolean = favoriteModel.isFavoritedTv(id)
}