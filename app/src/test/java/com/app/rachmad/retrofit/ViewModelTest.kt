package com.app.rachmad.retrofit

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.app.rachmad.movie.`object`.GenreData
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.helper.Utils
import com.app.rachmad.movie.viewmodel.ListModel
import org.hamcrest.Matchers.*
import org.junit.Test
import org.junit.Assert.*
import org.junit.Before
import org.hamcrest.collection.IsCollectionWithSize.hasSize
import java.util.*
import java.util.Arrays.asList
import java.util.Arrays.asList
import org.junit.Rule

class ViewModelTest {
    lateinit var viewModel: ListModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun init(){
        viewModel = ListModel()
    }

    @Test
    fun testMovie() {
        viewModel.movie()
        val movie = viewModel.getMovieData()
        movie.observeForever {
            assertNotNull(it)
            assertThat(it, hasSize(20))
            it.forEach {
                assertThat(it.overview, not(isEmptyOrNullString()))
                assertThat(it.popularity, greaterThan(0F))
                assertThat(it.vote_count, not(0))
                assertThat(it.poster_path, not(isEmptyOrNullString()))
                assertThat(it.id, not(0))
                assertThat(it.backdrop_path, not(isEmptyOrNullString()))
                assertThat(it.original_language, not(isEmptyOrNullString()))
                assertThat(it.original_title, not(isEmptyOrNullString()))
                assertThat(it.title, not(isEmptyOrNullString()))
                assertThat(it.vote_average, not(0F))
                assertThat(it.overview, not(isEmptyOrNullString()))
                assertThat(it.release_date, not(isEmptyOrNullString()))
            }
        }
    }

    @Test
    fun movieDetails(){
        viewModel.movie()
        val movie = viewModel.getMovieData()
        movie.observeForever {
            assertEquals(20, it.size)

            assertEquals("Joker", it[0].title)
            assertEquals("Oct 2019", Utils.dateFormat(it[0].release_date))
            assertEquals(8.4F, it[0].vote_average)
            assertEquals(5518, it[0].vote_count)
            assertThat(it[0].overview, not(isEmptyOrNullString()))

            viewModel.genre()
            val genre = viewModel.getGenreList()

            genre.observeForever { genre ->
                it[0].genre_ids.forEach { genre_id ->
                    val find = genre.filter { it.id == genre_id }
                    if(find.size > 0) {
                        assertEquals(genre_id, find[0].id)
                        assertThat(find, containsInAnyOrder(
                                GenreData(genre_id, find[0].name)
                        ))
                    }
                }
            }
        }
    }

    @Test
    fun testTv() {
        viewModel.tv()
        val tvData = viewModel.getTvData()

        tvData.observeForever { tv ->
            assertNotNull(tv)
            assertThat(tv, hasSize(20))
            tv?.forEach {
                assertThat(it.overview, not(isEmptyOrNullString()))
                assertThat(it.popularity, greaterThan(0F))
                assertThat(it.vote_count, not(0))
                assertThat(it.poster_path, not(isEmptyOrNullString()))
                assertThat(it.id, not(0))
                assertThat(it.backdrop_path, not(isEmptyOrNullString()))
                assertThat(it.original_language, not(isEmptyOrNullString()))
                assertThat(it.original_name, not(isEmptyOrNullString()))
                assertThat(it.name, not(isEmptyOrNullString()))
                assertThat(it.vote_average, not(0F))
                assertThat(it.overview, not(isEmptyOrNullString()))
                assertThat(it.first_air_date, not(isEmptyOrNullString()))
            }
        }
    }

    @Test
    fun tvDetails(){
        viewModel.tv()
        val tvData = viewModel.getTvData()

        tvData.observeForever { tv ->

        }
    }
}