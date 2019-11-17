package com.app.rachmad.movie.`object`
import java.io.Serializable

data class MovieData(
        val popularity: Float,
        val vote_count: Int,
        val video: Boolean,
        val poster_path: String,
        val id: Int,
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

data class GenreData(
        val id: Int,
        val name: List<String>
)