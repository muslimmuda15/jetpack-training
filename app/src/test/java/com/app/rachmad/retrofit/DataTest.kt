package com.app.rachmad.movie

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import com.app.rachmad.movie.`object`.*
import com.app.rachmad.movie.helper.Utils
import com.google.gson.Gson
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.runner.RunWith
import java.text.SimpleDateFormat
import java.util.*

class DataTest {
    lateinit var movieData: List<MovieData>
    lateinit var tvData: List<TvData>
    lateinit var genreData: List<GenreData>

    @Before
    fun init(){
        movieData = Utils.getMovieArray()
        tvData = Utils.getTvArray()
        genreData = Utils.getGenreArray()
    }

    @Test
    fun isMovieNull(){
        assertNotNull(Utils.getMovieJson())
    }

    @Test
    fun isTvNull(){
        assertNotNull(Utils.getTvJson())
    }

    @Test
    fun isGenreNull(){
        assertNotNull(Utils.getGenreJson())
    }

    @Test
    fun addition_isCorrectDateProject(){
        assertEquals("Jul 2001", Utils.dateFormat("2001-07-19"))
    }

    @Test
    fun checkMovieData(){
        assertEquals(20, movieData.size)

        movieData.forEach {
            assertNotNull(it.popularity)
            assertNotNull(it.vote_count)
            assertNotNull(it.video)
            assertNotNull(it.poster_path)
            assertNotNull(it.id)
            assertNotNull(it.adult)
            assertNotNull(it.backdrop_path)
            assertNotNull(it.original_language)
            assertNotNull(it.original_title)
            assertNotNull(it.title)
            assertNotNull(it.vote_average)
            assertNotNull(it.overview)
            assertNotNull(it.release_date)
        }
    }

    @Test
    fun checkMovieDetailData(){
        assertEquals(20, movieData.size)

        assertEquals("Joker", movieData[0].title)
        assertEquals("Oct 2019", Utils.dateFormat(movieData[0].release_date))
        assertEquals(8.4F, movieData[0].vote_average)
        assertEquals(5518, movieData[0].vote_count)
    }

    @Test
    fun checkTvData(){
        assertEquals(20, tvData.size)

        tvData.forEach {
            assertNotNull(it.popularity)
            assertNotNull(it.vote_count)
            assertNotNull(it.poster_path)
            assertNotNull(it.id)
            assertNotNull(it.backdrop_path)
            assertNotNull(it.original_language)
            assertNotNull(it.original_name)
            assertNotNull(it.name)
            assertNotNull(it.vote_average)
            assertNotNull(it.overview)
            assertNotNull(it.first_air_date)
        }
    }

    @Test
    fun checkTvDetailData(){
        assertEquals(20, tvData.size)

        assertEquals("Rick and Morty", tvData[0].name)
        assertEquals("Dec 2013", Utils.dateFormat(tvData[0].first_air_date))
        assertEquals(8.6F, tvData[0].vote_average)
        assertEquals(1471, tvData[0].vote_count)
    }

    @Test
    fun checkGenreData(){
        assertEquals(19, genreData!!.size)

        genreData.forEach {
            assertNotNull(it.id)
            assertNotNull(it.name)
        }
    }

    @Test
    fun checkGenreDetailsData(){
        assertEquals(19, genreData!!.size)

        assertSame(28, genreData[0].id)
        assertEquals("Action", genreData[0].name)
    }
}
