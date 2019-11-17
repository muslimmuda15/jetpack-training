package com.app.rachmad.movie

import android.util.Log
import android.view.View
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
import androidx.recyclerview.widget.RecyclerView
import androidx.annotation.IdRes
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import com.app.rachmad.movie.movie.MovieItemRecyclerViewAdapter
import org.hamcrest.Description
import org.hamcrest.TypeSafeMatcher
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.annotation.NonNull
import com.app.rachmad.movie.`object`.MovieBaseData
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.`object`.TvBaseData
import com.app.rachmad.movie.assertion.Assertion.atPositionOnView
import com.app.rachmad.movie.assertion.Assertion.getCountFromRecyclerView
import com.app.rachmad.movie.helper.Utils
import com.app.rachmad.movie.viewmodel.ListModel
import org.hamcrest.Matcher
import org.junit.Before


@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    lateinit var viewModel: ListModel
    lateinit var movieBaseData: MovieBaseData
    lateinit var tvBaseData: TvBaseData

    @Before
    fun init(){
        viewModel = activityRule.activity.viewModel!!
        movieBaseData = viewModel.getMovieData()!!
        tvBaseData = viewModel.getTvData()!!
    }

    @Test
    fun checkMovieTvFragment(){
        onView(allOf(withId(R.id.movie_list), isDisplayed()))
        getCountFromRecyclerView(R.id.movie_list, 10)

        movieBaseData.results.forEachIndexed { i, it ->
            onView(allOf(withId(R.id.movie_list))).perform(RecyclerViewActions.scrollToPosition<MovieItemRecyclerViewAdapter.ViewHolder>(i)).check(matches(atPositionOnView(i, withText(it.name[0]), R.id.movie_title)))
            onView(allOf(withId(R.id.movie_list))).check(matches(atPositionOnView(i, withText(it.overview[0]), R.id.movie_overview)))
            onView(allOf(withId(R.id.movie_list))).check(matches(atPositionOnView(i, withText(Utils.dateFormat(it.release_date)), R.id.movie_date)))

            onView(allOf(withId(R.id.movie_list), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<MovieItemRecyclerViewAdapter.ViewHolder>(i, click()))

            onView(allOf(withId(R.id.title_movie))).check(matches(withText(it.name[0])))
            onView(allOf(withId(R.id.date_release))).check(matches(withText(Utils.dateFormat(it.release_date))))
            onView(allOf(withId(R.id.votes))).check(matches(withText(activityRule.activity.resources.getQuantityString(R.plurals.vote, it.vote_count, it.vote_count))))
            onView(allOf(withId(R.id.overview_text))).check(matches(withText(it.overview[0])))

            onView(isRoot()).perform(ViewActions.pressBack())
        }

        onView(allOf(withId(R.id.tv), isDisplayed())).perform(click())

        onView(allOf(withId(R.id.tv_list), isDisplayed()))
        getCountFromRecyclerView(R.id.tv_list, 10)

        tvBaseData.results.forEachIndexed { i, it ->
            onView(allOf(withId(R.id.tv_list))).perform(RecyclerViewActions.scrollToPosition<MovieItemRecyclerViewAdapter.ViewHolder>(i)).check(matches(atPositionOnView(i, withText(it.name[0]), R.id.tv_title)))
            onView(allOf(withId(R.id.tv_list))).check(matches(atPositionOnView(i, withText(it.overview[0]), R.id.tv_overview)))
            onView(allOf(withId(R.id.tv_list))).check(matches(atPositionOnView(i, withText(Utils.dateFormat(it.release_date)), R.id.tv_date)))

            onView(allOf(withId(R.id.tv_list), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition<MovieItemRecyclerViewAdapter.ViewHolder>(i, click()))

            onView(allOf(withId(R.id.title_movie))).check(matches(withText(it.name[0])))
            onView(allOf(withId(R.id.date_release))).check(matches(withText(Utils.dateFormat(it.release_date))))
            onView(allOf(withId(R.id.votes))).check(matches(withText(activityRule.activity.resources.getQuantityString(R.plurals.vote, it.vote_count, it.vote_count))))
            onView(allOf(withId(R.id.overview_text))).check(matches(withText(it.overview[0])))

            onView(isRoot()).perform(ViewActions.pressBack())
        }
    }
}