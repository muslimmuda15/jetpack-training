package com.app.rachmad.movie

import com.app.rachmad.movie.`object`.GenreData
import com.app.rachmad.movie.`object`.MovieBaseData
import com.app.rachmad.movie.`object`.TvBaseData
import com.app.rachmad.movie.helper.Utils
import com.google.gson.Gson
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import java.text.SimpleDateFormat
import java.util.*

class UtilsTest {
    lateinit var movieBaseData: MovieBaseData
    lateinit var tvBaseData: TvBaseData
    lateinit var genreData: List<GenreData>

    @Before
    fun init(){
        movieBaseData = Gson().fromJson(MovieBaseData.MOVIE, MovieBaseData::class.java)
        tvBaseData = Gson().fromJson(TvBaseData.TV, TvBaseData::class.java)
        genreData = Utils.getJsonArray(GenreData.DATA)
    }

    @Test
    fun addition_isCorrectDate() {
        var df = SimpleDateFormat("yyyy-MM-dd", Locale.US)
        val newDate = df.parse("2001-07-19")
        df = SimpleDateFormat("MMM yyyy", Locale.US)
        assertEquals("Jul 2001", df.format(newDate))
    }

    @Test
    fun addition_isCorrectDateProject(){
        assertEquals("Jul 2001", Utils.dateFormat("2001-07-19"))
    }

    @Test
    fun checkMovieData(){
        assertEquals(10, movieBaseData!!.results.size)

        movieBaseData.results.forEach {
            assertNotNull(it.popularity)
            assertNotNull(it.vote_count)
            assertNotNull(it.video)
            assertNotNull(it.poster_path)
            assertNotNull(it.id)
            assertNotNull(it.adult)
            assertNotNull(it.backdrop_path)
            assertNotNull(it.original_language)
            assertNull(it.original_name)
            assertNotNull(it.name)
            assertNotNull(it.vote_average)
            assertNotNull(it.overview)
            assertNotNull(it.release_date)
        }
    }

    @Test
    fun checkMovieDetailData(){
        assertEquals(10, movieBaseData!!.results.size)

        val movieData = movieBaseData!!.results
        assertEquals("The Lion King", movieData[0].name[0])
        assertEquals("Jul 2019", Utils.dateFormat(movieData[0].release_date))
        assertEquals(7.2F, movieData[0].vote_average)
        assertEquals(2038, movieData[0].vote_count)
    }

    @Test
    fun checkTvData(){
        assertEquals(10, tvBaseData!!.results.size)

        tvBaseData.results.forEach {
            assertNotNull(it.popularity)
            assertNotNull(it.vote_count)
            assertNotNull(it.video)
            assertNotNull(it.poster_path)
            assertNotNull(it.id)
            assertNotNull(it.adult)
            assertNotNull(it.backdrop_path)
            assertNotNull(it.original_language)
            assertNotNull(it.original_name)
            assertNotNull(it.name)
            assertNotNull(it.vote_average)
            assertNotNull(it.overview)
            assertNotNull(it.release_date)
        }
    }

    @Test
    fun checkTvDetailData(){
        assertEquals(10, tvBaseData!!.results.size)

        val movieData = tvBaseData!!.results
        assertEquals("The Flash", movieData[0].name[0])
        assertEquals("Oct 2014", Utils.dateFormat(movieData[0].release_date))
        assertEquals(6.6F, movieData[0].vote_average)
        assertEquals(2809, movieData[0].vote_count)
    }

    @Test
    fun checkGenreData(){
        assertEquals(19, genreData!!.size)

        genreData.forEach {
            assertNotNull(it.id)
            assertNotNull(it.name)
        }
    }
}
