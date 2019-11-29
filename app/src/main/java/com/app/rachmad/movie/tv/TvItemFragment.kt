package com.app.rachmad.movie.tv

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
import com.app.rachmad.movie.`object`.TvData
import com.app.rachmad.movie.`object`.TvDataFavorite
import com.app.rachmad.movie.favorite.TvFavoriteItemRecyclerViewAdapter
import com.app.rachmad.movie.viewmodel.ListModel
import kotlinx.android.synthetic.main.fragment_tv_item_list.view.*

class TvItemFragment : Fragment() {

    private var listener: OnTvClickListener? = null
    private var listenerFavorite: OnTvFavoriteListener? = null
    private lateinit var adapter: TvItemRecyclerViewAdapter
    private lateinit var adapterFavorite: TvFavoriteItemRecyclerViewAdapter
    var viewModel: ListModel? = null
    var isFavorite = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            isFavorite = it.getBoolean(ARG_IS_FAVORITE_TV)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tv_item_list, container, false)
        viewModel = (activity as BaseActivity).viewModel

        if(isFavorite){
            if(viewModel!!.countAllFavoriteTv() > 0) {
                view.tv_list.visibility = RecyclerView.VISIBLE
                view.no_tv.visibility = View.GONE

                var tvFavorite = viewModel?.tvFavoriteLiveData
                tvFavorite?.observe(this, Observer<PagedList<TvDataFavorite>> {
                    adapterFavorite = TvFavoriteItemRecyclerViewAdapter(listenerFavorite)
                    adapterFavorite.submitList(it)
                    if (view.tv_list is RecyclerView) {
                        view.tv_list.layoutManager = LinearLayoutManager(context)
                        view.tv_list.adapter = adapterFavorite
                    }
                })
            }
            else{
                view.tv_list.visibility = RecyclerView.GONE
                view.no_tv.visibility = View.VISIBLE
            }
        }
        else {
            view.tv_list.visibility = RecyclerView.VISIBLE
            view.no_tv.visibility = View.GONE

            viewModel?.tv()
            val data = viewModel?.getTvData()

            data!!.observe(this, Observer<List<TvData>> {
                adapter = TvItemRecyclerViewAdapter(it, listener)

                if (view.tv_list is RecyclerView) {
                    view.tv_list.layoutManager = LinearLayoutManager(context)
                    view.tv_list.adapter = adapter
                }
            })
        }
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnTvClickListener) {
            listener = context
        }
        else if(context is OnTvFavoriteListener){
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

    interface OnTvClickListener {
        fun onClickTv(item: TvData)
    }

    interface OnTvFavoriteListener {
        fun onClickTv(item: TvDataFavorite)
    }

    companion object {
        const val ARG_IS_FAVORITE_TV = "IsFavoriteTv"

        @JvmStatic
        fun newInstance(isFavorite: Boolean) = TvItemFragment().apply {
            arguments = Bundle().apply {
                putBoolean(ARG_IS_FAVORITE_TV, isFavorite)
            }
        }
    }
}
