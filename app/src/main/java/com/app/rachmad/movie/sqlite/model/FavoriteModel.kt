package com.app.rachmad.movie.sqlite.model

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.app.rachmad.movie.`object`.MovieDataFavorite
import com.app.rachmad.movie.`object`.TvDataFavorite
import com.app.rachmad.movie.sqlite.CinemaDatabase

class FavoriteModel(c: Context) {
    val database = CinemaDatabase.getInstance(c)

    fun getFavoriteMovieList(): DataSource.Factory<Int, MovieDataFavorite>?{
        var favoriteList: DataSource.Factory<Int, MovieDataFavorite>? = null
        database?.let {
            favoriteList = it.favoriteDatabase().getFavoriteMovieList()
        }
        return favoriteList
    }

    fun getFavoriteTvList(): DataSource.Factory<Int, TvDataFavorite>?{
        var favoriteList: DataSource.Factory<Int, TvDataFavorite>? = null
        database?.let {
            favoriteList = it.favoriteDatabase().getFavoriteTvList()
        }
        return favoriteList
    }

    fun countAllFavoriteMovie(): Int {
        return database?.favoriteDatabase()?.countAllFavoriteMovie() ?: 0
    }

    fun countAllFavoriteTv(): Int {
        return database?.favoriteDatabase()?.countAllFavoriteTv() ?: 0
    }

    fun insertMovieFavorite(movieData: MovieDataFavorite){
        database?.favoriteDatabase()?.insertMovieFavorite(movieData)
    }

    fun insertTvFavorite(tvData: TvDataFavorite){
        database?.favoriteDatabase()?.insertTvFavorite(tvData)
    }

    fun countFavoritedMovieLive(id: Int): LiveData<Int>{
        var favorited: LiveData<Int> = MutableLiveData()
        database?.let {
            favorited = it.favoriteDatabase().countFavoriteMovieLive(id)
        }
        return favorited
    }

    fun countFavoritedTvLive(id: Int): LiveData<Int>{
        var favorited: LiveData<Int> = MutableLiveData()
        database?.let {
            favorited = it.favoriteDatabase().countFavoriteTvLive(id)
        }
        return favorited
    }

    fun deleteMovieFavorite(movieData: MovieDataFavorite){
        database?.favoriteDatabase()?.deleteMovieFavorite(movieData)
    }

    fun deleteTvFavorite(tvData: TvDataFavorite){
        database?.favoriteDatabase()?.deleteTvFavorite(tvData)
    }

    fun isFavoritedMovie(id: Int): Boolean{
        var favorited = false
        database?.let {
            favorited = if(it.favoriteDatabase().countFavoriteMovie(id) > 0)
                true
            else
                false
        }
        return favorited
    }

    fun isFavoritedTv(id: Int): Boolean{
        var favorited = false
        database?.let {
            favorited = if(it.favoriteDatabase().countFavoriteTv(id) > 0)
                true
            else
                false
        }
        return favorited
    }
}