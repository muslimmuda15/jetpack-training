package com.app.rachmad.movie.`object`

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class TvData(
        val id: Int,
        val original_name: String,
        val genre_ids: List<Int>,
        val name: String,
        val popularity: Float,
        val vote_count: Int,
        val first_air_date: String,
        val backdrop_path: String,
        val original_language: String,
        val vote_average: Float,
        val overview: String,
        val poster_path: String
): Serializable

@Entity(tableName = "tv")
data class TvDataFavorite(
        @PrimaryKey
        @ColumnInfo(name = "id") val id: Int,
        @ColumnInfo(name = "original_name") val original_name: String,
        @ColumnInfo(name = "genre_ids") val genre_ids: String,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "popularity") val popularity: Float,
        @ColumnInfo(name = "vote_count") val vote_count: Int,
        @ColumnInfo(name = "first_air_date") val first_air_date: String,
        @ColumnInfo(name = "backdrop_path") val backdrop_path: String,
        @ColumnInfo(name = "original_language") val original_language: String,
        @ColumnInfo(name = "vote_average") val vote_average: Float,
        @ColumnInfo(name = "overview") val overview: String,
        @ColumnInfo(name = "poster_path") val poster_path: String
): Serializable