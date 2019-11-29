package com.app.rachmad.movie.`object`
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

data class MovieData(
        val id: Int,
        val popularity: Float,
        val vote_count: Int,
        val video: Boolean,
        val poster_path: String,
        val adult: Boolean,
        val backdrop_path: String,
        val original_language: String,
        val original_title: String?,
        val genre_ids: List<Int>,
        val title: String,
        val vote_average: Float,
        val overview: String,
        val release_date: String
): Serializable

@Entity(tableName = "movie")
data class MovieDataFavorite(
        @PrimaryKey
        @ColumnInfo(name = "id") val id: Int,
        @ColumnInfo(name = "popularity") val popularity: Float,
        @ColumnInfo(name = "vote_count") val vote_count: Int,
        @ColumnInfo(name = "video") val video: Boolean,
        @ColumnInfo(name = "poster_path") val poster_path: String,
        @ColumnInfo(name = "adult") val adult: Boolean,
        @ColumnInfo(name = "backdrop_path") val backdrop_path: String,
        @ColumnInfo(name = "original_language") val original_language: String,
        @ColumnInfo(name = "original_title") val original_title: String?,
        @ColumnInfo(name = "genre_ids") val genre_ids: String,
        @ColumnInfo(name = "title") val title: String,
        @ColumnInfo(name = "vote_average") val vote_average: Float,
        @ColumnInfo(name = "overview") val overview: String,
        @ColumnInfo(name = "release_date") val release_date: String
): Serializable

data class GenreData(
        val id: Int,
        val name: String
)