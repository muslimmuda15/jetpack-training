package com.app.rachmad.movie

import android.util.Log
import android.view.View
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import org.hamcrest.CoreMatchers.allOf
import org.junit.Rule
import org.junit.Test
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import com.app.rachmad.movie.movie.MovieItemRecyclerViewAdapter
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.`object`.TvData
import com.app.rachmad.movie.assertion.Assertion.atPositionOnView
import com.app.rachmad.movie.assertion.Assertion.getCountFromRecyclerView
import com.app.rachmad.movie.helper.Utils
import com.app.rachmad.movie.viewmodel.ListModel
import org.junit.Before

@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    lateinit var viewModel: ListModel
    lateinit var movieData: LiveData<List<MovieData>>
    lateinit var tvData: LiveData<List<TvData>>

    @Before
    fun init(){
        viewModel = activityRule.activity.viewModel!!
        movieData = viewModel.getMovieData()
        tvData = viewModel.getTvData()
    }

    @Test
    fun checkMovieTvFragment(){
        onView(allOf(withId(R.id.movie_list), isDisplayed()))
        getCountFromRecyclerView(R.id.movie_list, 20)

        movieData.observeForever {
            it.forEachIndexed { i, movie ->
                onView(allOf(withId(R.id.movie_list))).perform(RecyclerViewActions.scrollToPosition<MovieItemRecyclerViewAdapter.ViewHolder>(i)).check(matches(atPositionOnView(i, withText(movie.title), R.id.movie_title)))
                onView(allOf(withId(R.id.movie_list))).check(matches(atPositionOnView(i, withText(movie.overview), R.id.movie_overview)))
                onView(allOf(withId(R.id.movie_list))).check(matches(atPositionOnView(i, withText(Utils.dateFormat(movie.release_date)), R.id.movie_date)))

                onView(allOf(withId(R.id.movie_list), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<MovieItemRecyclerViewAdapter.ViewHolder>(i, click()))

                onView(allOf(withId(R.id.title_movie))).check(matches(withText(movie.title)))
                onView(allOf(withId(R.id.date_release))).check(matches(withText(Utils.dateFormat(movie.release_date))))
                onView(allOf(withId(R.id.votes))).check(matches(withText(activityRule.activity.resources.getQuantityString(R.plurals.vote, movie.vote_count, movie.vote_count))))
                onView(allOf(withId(R.id.overview_text))).check(matches(withText(movie.overview)))

                onView(isRoot()).perform(ViewActions.pressBack())
            }
        }

        onView(allOf(withId(R.id.tv), isDisplayed())).perform(click())

        onView(allOf(withId(R.id.tv_list), isDisplayed()))
        getCountFromRecyclerView(R.id.tv_list, 20)

        tvData.observeForever {
            it.forEachIndexed { i, tv ->
                onView(allOf(withId(R.id.tv_list))).perform(RecyclerViewActions.scrollToPosition<MovieItemRecyclerViewAdapter.ViewHolder>(i)).check(matches(atPositionOnView(i, withText(tv.name), R.id.tv_title)))
                onView(allOf(withId(R.id.tv_list))).check(matches(atPositionOnView(i, withText(tv.overview), R.id.tv_overview)))
                onView(allOf(withId(R.id.tv_list))).check(matches(atPositionOnView(i, withText(Utils.dateFormat(tv.first_air_date)), R.id.tv_date)))

                onView(allOf(withId(R.id.tv_list), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<MovieItemRecyclerViewAdapter.ViewHolder>(i, click()))

                onView(allOf(withId(R.id.title_movie))).check(matches(withText(tv.name)))
                onView(allOf(withId(R.id.date_release))).check(matches(withText(Utils.dateFormat(tv.first_air_date))))
                onView(allOf(withId(R.id.votes))).check(matches(withText(activityRule.activity.resources.getQuantityString(R.plurals.vote, tv.vote_count, tv.vote_count))))
                onView(allOf(withId(R.id.overview_text))).check(matches(withText(tv.overview)))

                onView(isRoot()).perform(ViewActions.pressBack())
            }
        }
    }
}