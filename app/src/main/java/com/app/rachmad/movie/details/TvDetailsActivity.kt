package com.app.rachmad.movie.details

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import androidx.lifecycle.ViewModelProviders
import com.app.rachmad.movie.BuildConfig
import com.app.rachmad.movie.GlideApp
import com.app.rachmad.movie.R
import com.app.rachmad.movie.`object`.GenreData
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.`object`.TvData
import com.app.rachmad.movie.helper.Utils
import com.app.rachmad.movie.viewmodel.ListModel
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_movie_details.*
import kotlinx.android.synthetic.main.custom_chip.view.*

const val TV_EXTRA = "TvExtra"
class TvDetailsActivity : AppCompatActivity() {
    lateinit var tvData: TvData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        val viewModel = ViewModelProviders.of(this).get(ListModel::class.java)

        tvData = intent.getSerializableExtra(TV_EXTRA) as TvData

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp)
        supportActionBar?.setDisplayShowTitleEnabled(true)

        var imageHeight = 0

        with(tvData) {
            supportActionBar?.title = HtmlCompat.fromHtml("<font color='#ffffff'>${name[0]}</font>", HtmlCompat.FROM_HTML_MODE_LEGACY)

            GlideApp.with(movie_image)
                    .load("${BuildConfig.SERVER_URL}$backdrop_path")
                    .centerCrop()
                    .listener(object: RequestListener<Drawable> {
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            return false
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            back_drop_loading.stopShimmer()
                            back_drop_loading.visibility = ViewGroup.GONE
                            return false
                        }
                    })
                    .into(movie_image)

            GlideApp.with(poster_image)
                    .load("${BuildConfig.SERVER_URL}$poster_path")
                    .centerCrop()
                    .listener(object: RequestListener<Drawable>{
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            return false
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            poster_loading.stopShimmer()
                            poster_loading.visibility = ViewGroup.GONE
                            return false
                        }
                    })
                    .into(poster_image)

            date_release.text = Utils.dateFormat(release_date)

            title_movie.text = name[0]
            overview_text.text = overview[0]

            movie_rating_star.rating = vote_average / 2
            rating_text.text = vote_average.toString()

            votes.text = resources.getQuantityString(R.plurals.vote, vote_count, vote_count)

            viewModel.genre()
            val genre: List<GenreData> = viewModel.getGenreList()

            genre_ids.forEach { genre_id ->
                val genreCard = layoutInflater.inflate(R.layout.custom_chip, null) as FrameLayout
                val genreText = genre.find { it.id == genre_id.toInt() }
                genreText?.let {
                    genreCard.genre_text.text = it.name[0]
                    genres.addView(genreCard)
                }
            }
        }

        movie_image.viewTreeObserver.addOnGlobalLayoutListener(object: ViewTreeObserver.OnGlobalLayoutListener{
            override fun onGlobalLayout() {
                movie_image.viewTreeObserver.removeOnGlobalLayoutListener(this)
                imageHeight = movie_image.measuredHeight
            }
        })

        scroll.viewTreeObserver.addOnScrollChangedListener {
            Log.d("data", "SCROLL Y : " + scroll.scrollY)
            if(scroll.scrollY == 0){
                toolbar.background.alpha = 0
                Log.d("scroll", "transparent : " + 0)
            }
            else if(scroll.scrollY > 0){
                val transparent = ((scroll.scrollY.toFloat() / imageHeight.toFloat()) * 255.toFloat()).toInt()
                Log.d("scroll", "(${scroll.scrollY.toFloat()} / ${imageHeight.toFloat()}) * ${255.toFloat()}")
                Log.d("scroll", "transparent : " + transparent)
                if (transparent <= 255) {
                    toolbar.background.alpha = transparent
                }
                else if(transparent > 255)
                    toolbar.background.alpha = 255
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.activity_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }
}
