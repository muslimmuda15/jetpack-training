package com.app.rachmad.movie.movie

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.app.rachmad.movie.BaseActivity
import com.app.rachmad.movie.MainActivity
import com.app.rachmad.movie.R
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.`object`.MovieDataFavorite
import com.app.rachmad.movie.favorite.FavoriteActivity
import com.app.rachmad.movie.favorite.MovieFavoriteItemRecyclerViewAdapter
import com.app.rachmad.movie.viewmodel.ListModel
import kotlinx.android.synthetic.main.fragment_movie_item_list.view.*

class MovieItemFragment : Fragment() {
    private var listener: OnMovieClickListener? = null
    private var listenerFavorite: OnMovieFavoriteListener? = null
    private lateinit var adapter: MovieItemRecyclerViewAdapter
    private lateinit var adapterFavorite: MovieFavoriteItemRecyclerViewAdapter
    var viewModel: ListModel? = null

    var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            isFavorite = it.getBoolean(ARG_IS_FAVORITE_MOVIE)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movie_item_list, container, false)
        viewModel = (activity as BaseActivity).viewModel

        if(isFavorite){
            if(viewModel!!.countAllFavoriteMovie() > 0) {
                view.movie_list.visibility = RecyclerView.VISIBLE
                view.no_movie.visibility = View.GONE

                var movieFavorite = viewModel?.movieFavoriteLiveData
                movieFavorite?.observe(this, Observer<PagedList<MovieDataFavorite>> {
                    adapterFavorite = MovieFavoriteItemRecyclerViewAdapter(listenerFavorite)
                    adapterFavorite.submitList(it)
                    if (view.movie_list is RecyclerView) {
                        view.movie_list.layoutManager = LinearLayoutManager(context)
                        view.movie_list.adapter = adapterFavorite
                    }
                })
            }
            else{
                view.movie_list.visibility = RecyclerView.GONE
                view.no_movie.visibility = View.VISIBLE
            }
        }
        else {
            view.movie_list.visibility = RecyclerView.VISIBLE
            view.no_movie.visibility = View.GONE

            viewModel?.movie()
            val data = viewModel?.getMovieData()

            data!!.observe(this, Observer<List<MovieData>> {
                adapter = MovieItemRecyclerViewAdapter(it, listener)
                if (view.movie_list is RecyclerView) {
                    view.movie_list.layoutManager = LinearLayoutManager(context)
                    view.movie_list.adapter = adapter
                }
            })
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMovieClickListener) {
            listener = context
        }
        else if (context is OnMovieFavoriteListener){
            listenerFavorite = context
        }
        else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnMovieClickListener {
        fun onClickMovie(item: MovieData)
    }

    interface OnMovieFavoriteListener {
        fun onClickMovie(item: MovieDataFavorite)
    }

    companion object {
        const val ARG_IS_FAVORITE_MOVIE = "IsFavoriteMovie"

        @JvmStatic
        fun newInstance(isFavorite: Boolean) = MovieItemFragment().apply {
            arguments = Bundle().apply {
                putBoolean(ARG_IS_FAVORITE_MOVIE, isFavorite)
            }
        }
    }
}
