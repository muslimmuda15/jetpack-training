package com.app.rachmad.movie.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.app.rachmad.movie.MainActivity
import com.app.rachmad.movie.`object`.*
import com.app.rachmad.movie.helper.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MovieRepository{
    var movieData: MovieBaseData? = null
    var tvData: TvBaseData? = null
    var genreList: List<GenreData> = ArrayList()

    fun movie(){
        movieData = Gson().fromJson(MovieBaseData.MOVIE, MovieBaseData::class.java)
    }

    fun tv(){
        tvData = Gson().fromJson(TvBaseData.TV, TvBaseData::class.java)
    }

    fun genre(){
        genreList = Utils.getJsonArray(GenreData.DATA)
    }
}