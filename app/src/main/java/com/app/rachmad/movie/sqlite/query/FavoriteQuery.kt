package com.app.rachmad.movie.sqlite.query

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.app.rachmad.movie.`object`.MovieDataFavorite
import com.app.rachmad.movie.`object`.TvDataFavorite

@Dao
interface FavoriteQuery {
    @Query("select * from movie")
    fun getFavoriteMovieList(): DataSource.Factory<Int, MovieDataFavorite>

    @Query("select * from tv")
    fun getFavoriteTvList(): DataSource.Factory<Int, TvDataFavorite>

    @Insert(onConflict = REPLACE)
    fun insertMovieFavorite(movieData: MovieDataFavorite)

    @Insert(onConflict = REPLACE)
    fun insertTvFavorite(tvData: TvDataFavorite)

    @Query("select count(*) from movie")
    fun countAllFavoriteMovie(): Int

    @Query("select count(*) from tv")
    fun countAllFavoriteTv(): Int

    @Query("select count(*) from movie where id = :id")
    fun countFavoriteMovieLive(id: Int): LiveData<Int>

    @Query("select count(*) from tv where id = :id")
    fun countFavoriteTvLive(id: Int): LiveData<Int>

    @Delete
    fun deleteMovieFavorite(movieData: MovieDataFavorite)

    @Delete
    fun deleteTvFavorite(tvData: TvDataFavorite)

    @Query("select count(*) from movie where id = :id")
    fun countFavoriteMovie(id: Int): Int

    @Query("select count(*) from tv where id = :id")
    fun countFavoriteTv(id: Int): Int
}