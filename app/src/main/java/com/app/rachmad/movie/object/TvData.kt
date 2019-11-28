package com.app.rachmad.movie.`object`

import java.io.Serializable

data class TvData(
        val original_name: String,
        val genre_ids: List<Int>,
        val name: String,
        val popularity: Float,
        val vote_count: Int,
        val first_air_date: String,
        val backdrop_path: String,
        val original_language: String,
        val id: Int,
        val vote_average: Float,
        val overview: String,
        val poster_path: String
): Serializable