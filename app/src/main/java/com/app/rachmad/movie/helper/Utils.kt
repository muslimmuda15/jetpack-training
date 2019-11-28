package com.app.rachmad.movie.helper

import android.content.Context
import com.app.rachmad.movie.`object`.GenreData
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.`object`.TvData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_movie_details.*
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

object Utils {
    fun dateFormat(input: String): String {
        var df = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val newDate = df.parse(input)
        df = SimpleDateFormat("MMM yyyy", Locale.US)
        return df.format(newDate)
    }

    fun getGenreArray(): List<GenreData>{
        val listType = object : TypeToken<List<GenreData>>() { }.type
        return Gson().fromJson(getGenreJson(), listType)
    }

    fun getMovieArray(): List<MovieData>{
        val listType = object : TypeToken<List<MovieData>>() { }.type
        return Gson().fromJson(getMovieJson(), listType)
    }

    fun getTvArray(): List<TvData>{
        val listType = object : TypeToken<List<TvData>>() { }.type
        return Gson().fromJson(getTvJson(), listType)
    }

    fun getMovieJson(): String? {
        var json: String?
        try {
            val file = this.javaClass.classLoader!!.getResourceAsStream("movie.json")
            json = file.bufferedReader().use { it.readText() }
        } catch (ex: IOException) {
            ex.printStackTrace()
            json = null
        }

        return json
    }

    fun getTvJson(): String? {
        var json: String? = null
        try {
            val file = this.javaClass.classLoader!!.getResourceAsStream("tv.json")
            json = file.bufferedReader().use { it.readText() }
        } catch (ex: IOException) {
            ex.printStackTrace()
            json = null
        }

        return json
    }

    fun getGenreJson(): String? {
        var json: String?
        try {
            val file = this.javaClass.classLoader!!.getResourceAsStream("genres.json")
            json = file.bufferedReader().use { it.readText() }
        } catch (ex: IOException) {
            ex.printStackTrace()
            json = null
        }

        return json
    }
}