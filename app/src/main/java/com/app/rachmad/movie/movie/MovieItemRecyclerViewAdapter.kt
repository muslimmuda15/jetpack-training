package com.app.rachmad.movie.movie

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.rachmad.movie.GlideApp
import com.app.rachmad.movie.R
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.helper.Utils
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

import kotlinx.android.synthetic.main.fragment_movie_item.view.*

class MovieItemRecyclerViewAdapter(
        private val mValues: List<MovieData>?,
        private val mListener: MovieItemFragment.OnMovieClickListener?)
    : RecyclerView.Adapter<MovieItemRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener
    var language: Int = 0

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as MovieData
            mListener?.onClickMovie(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        mValues?.let {
            val item = it[position]
            GlideApp.with(holder.image)
                    .load("http://image.tmdb.org/t/p/w500" + item.poster_path)
                    .centerCrop()
                    .listener(object: RequestListener<Drawable>{
                        override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable>?, isFirstResource: Boolean): Boolean {
                            return false
                        }

                        override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                            holder.imageLoading.stopShimmer()
                            holder.imageLoading.visibility = ViewGroup.GONE
                            return false
                        }
                    })
                    .into(holder.image)

            with(holder) {
                title.text = item.name[0]
                overview.text = item.overview[0]

                date.text = Utils.dateFormat(item.release_date)

                ratingStar.rating = item.vote_average / 2
            }

            with(holder.mView) {
                tag = item
                setOnClickListener(mOnClickListener)
            }
        }
    }

    override fun getItemCount(): Int = mValues?.let { it.size } ?: run { 0 }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val image = mView.movie_image
        val title = mView.movie_title
        val overview = mView.movie_overview
        val date = mView.movie_date
        val ratingStar = mView.movie_rating_star
        val imageLoading = mView.movie_image_loading
    }
}
