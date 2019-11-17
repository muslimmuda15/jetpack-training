package com.app.rachmad.movie

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.ViewModelProviders
import androidx.viewpager.widget.ViewPager
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.`object`.TvData
import com.app.rachmad.movie.details.MOVIE_EXTRA
import com.app.rachmad.movie.details.MovieDetailsActivity
import com.app.rachmad.movie.details.TV_EXTRA
import com.app.rachmad.movie.details.TvDetailsActivity
import com.app.rachmad.movie.movie.ARG_DATA
import com.app.rachmad.movie.movie.ARG_TYPE
import com.app.rachmad.movie.movie.MovieItemFragment
import com.app.rachmad.movie.tv.TvItemFragment
import com.app.rachmad.movie.viewmodel.ListModel
import com.bumptech.glide.annotation.GlideModule
import com.bumptech.glide.module.AppGlideModule
import kotlinx.android.synthetic.main.activity_main.*

const val ARG_MOVIE = "Movie"
const val ARG_TV = "Tv"
class MainActivity : AppCompatActivity(), MovieItemFragment.OnMovieClickListener, TvItemFragment.OnTvClickListener {
    var viewModel: ListModel? = null
    lateinit var movieFragment: MovieItemFragment
    lateinit var tvFragment: TvItemFragment

    override fun onClickMovie(item: MovieData) {
        val intent = Intent(this, MovieDetailsActivity::class.java)
        intent.putExtra(MOVIE_EXTRA, item)
        startActivity(intent)
    }

    override fun onClickTv(item: TvData) {
        val intent = Intent(this, TvDetailsActivity::class.java)
        intent.putExtra(TV_EXTRA, item)
        startActivity(intent)
    }

    lateinit var pagerAdapter: PagerAdapter

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.movie -> {
                container.setCurrentItem(0, true)
                return@OnNavigationItemSelectedListener true
            }
            R.id.tv -> {
                container.setCurrentItem(1, true)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun initialize(){
        context = applicationContext
        viewModel = ViewModelProviders.of(this).get(ListModel::class.java)

        viewModel?.movie()
        val movieData = viewModel?.getMovieData()
        movieFragment = MovieItemFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_TYPE, ARG_MOVIE)
                putSerializable(ARG_DATA, movieData)
            }
        }

        viewModel?.tv()
        val tvData = viewModel?.getTvData()
        tvFragment = TvItemFragment().apply {
            arguments = Bundle().apply {
                putString(ARG_TYPE, ARG_TV)
                putSerializable(ARG_DATA, tvData)
            }
        }
    }

    private fun setupListener(){
        container.addOnPageChangeListener(object: ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {}

            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

            override fun onPageSelected(position: Int) {
                bottom_navigation.selectedItemId = when(position) {
                    0 -> R.id.movie
                    1 -> R.id.tv
                    else -> 0
                }
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialize()

        setSupportActionBar(toolbar)
        bottom_navigation.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        pagerAdapter = PagerAdapter(supportFragmentManager, 2)
        container.adapter = pagerAdapter
        pagerAdapter.notifyDataSetChanged()

        setupListener()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    inner class PagerAdapter(fragment: FragmentManager, count: Int): FragmentPagerAdapter(fragment, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
        val c = count

        override fun getCount(): Int {
            return c
        }

        override fun getItem(position: Int): Fragment {
            when(position){
                0 -> {
                    return movieFragment
                }
                1 -> {
                    return tvFragment
                }
                else -> {
                    return Fragment()
                }
            }
        }
    }

    companion object {
        lateinit var context: Context
    }
}

@GlideModule
class MyAppGlideModule : AppGlideModule()