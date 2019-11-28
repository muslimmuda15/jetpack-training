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
import com.app.rachmad.movie.MainActivity
import com.app.rachmad.movie.R
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.viewmodel.ListModel

class MovieItemFragment : Fragment() {
    private var listener: OnMovieClickListener? = null
    lateinit var adapter: MovieItemRecyclerViewAdapter
    var viewModel: ListModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_movie_item_list, container, false)

        viewModel = (activity as MainActivity).viewModel

        viewModel?.movie()
        val data = viewModel?.getMovieData()

        data!!.observe(this, Observer<List<MovieData>> {
            adapter = MovieItemRecyclerViewAdapter(it, listener)

            if (view is RecyclerView) {
                view.layoutManager = LinearLayoutManager(context)
                view.adapter = adapter
            }
        })
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnMovieClickListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnMovieClickListener {
        // TODO: Update argument type and name
        fun onClickMovie(item: MovieData)
    }

    companion object {
        @JvmStatic
        fun newInstance() = MovieItemFragment()
    }
}
