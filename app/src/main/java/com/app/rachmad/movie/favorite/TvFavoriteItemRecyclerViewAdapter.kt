package com.app.rachmad.movie.favorite

import android.graphics.drawable.Drawable
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.app.rachmad.movie.GlideApp
import com.app.rachmad.movie.R
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.`object`.TvData
import com.app.rachmad.movie.`object`.TvDataFavorite
import com.app.rachmad.movie.helper.Utils
import com.app.rachmad.movie.tv.TvItemFragment
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target

import kotlinx.android.synthetic.main.fragment_tv_item.view.*

class TvFavoriteItemRecyclerViewAdapter(
        private val mListener: TvItemFragment.OnTvFavoriteListener?)
    : PagedListAdapter<TvDataFavorite, TvFavoriteItemRecyclerViewAdapter.ViewHolder>(checkDifferent) {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as TvDataFavorite
            mListener?.onClickTv(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_tv_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let { item ->
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
                title.text = item.name
                overview.text = item.overview

                date.text = Utils.dateFormat(item.first_air_date)

                ratingStar.rating = item.vote_average / 2
            }

            with(holder.mView) {
                tag = item
                setOnClickListener(mOnClickListener)
            }
        }
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val image = mView.tv_image
        val title = mView.tv_title
        val overview = mView.tv_overview
        val date = mView.tv_date
        val ratingStar = mView.tv_rating_star
        val imageLoading = mView.tv_image_loading
    }

    companion object {
        val checkDifferent = object : DiffUtil.ItemCallback<TvDataFavorite>() {
            override fun areItemsTheSame(oldItem: TvDataFavorite, newItem: TvDataFavorite): Boolean =
                    oldItem.name == newItem.name

            override fun areContentsTheSame(oldItem: TvDataFavorite, newItem: TvDataFavorite): Boolean =
                    oldItem == newItem
        }
    }
}
