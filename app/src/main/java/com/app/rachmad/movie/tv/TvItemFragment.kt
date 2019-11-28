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
import com.app.rachmad.movie.MainActivity
import com.app.rachmad.movie.R
import com.app.rachmad.movie.`object`.TvData
import com.app.rachmad.movie.viewmodel.ListModel

class TvItemFragment : Fragment() {

    private var listener: OnTvClickListener? = null
    lateinit var adapter: TvItemRecyclerViewAdapter
    var viewModel: ListModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tv_item_list, container, false)

        viewModel = (activity as MainActivity).viewModel

        viewModel?.tv()
        val data = viewModel?.getTvData()

        data!!.observe(this, Observer<List<TvData>> {
            adapter = TvItemRecyclerViewAdapter(it, listener)

            if (view is RecyclerView) {
                view.layoutManager = LinearLayoutManager(context)
                view.adapter = adapter
            }
        })
        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnTvClickListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    interface OnTvClickListener {
        // TODO: Update argument type and name
        fun onClickTv(item: TvData)
    }

    companion object {
        @JvmStatic
        fun newInstance() = TvItemFragment()
    }
}
