package com.app.rachmad.movie.helper

import android.content.Context
import com.app.rachmad.movie.`object`.GenreData
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.`object`.TvBaseData
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

    fun getJsonArray(c: Context): List<GenreData>{
        val listType = object : TypeToken<List<GenreData>>() { }.type
        return Gson().fromJson(getGenreJson(c), listType)
    }

    fun getMovieArray(c: Context): List<MovieData>{
        val listType = object : TypeToken<List<GenreData>>() { }.type
        return Gson().fromJson(getMovieJson(c), listType)
    }

    fun getTvArray(c: Context): List<MovieData>{
        val listType = object : TypeToken<List<GenreData>>() { }.type
        return Gson().fromJson(getTvJson(c), listType)
    }

    fun getMovieJson(c: Context): String? {
        var json: String
        try {
            val file = c.getAssets().open("movie.json")
            val size = file.available()
            val buffer = ByteArray(size)
            file.read(buffer)
            file.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

    fun getTvJson(c: Context): String? {
        var json: String? = null
        try {
            val file = c.getAssets().open("tv.json")
            val size = file.available()
            val buffer = ByteArray(size)
            file.read(buffer)
            file.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }

    fun getGenreJson(c: Context): String? {
        var json: String? = null
        try {
            val file = c.getAssets().open("genres.json")
            val size = file.available()
            val buffer = ByteArray(size)
            file.read(buffer)
            file.close()
            json = String(buffer)
        } catch (ex: IOException) {
            ex.printStackTrace()
            return null
        }

        return json
    }
}