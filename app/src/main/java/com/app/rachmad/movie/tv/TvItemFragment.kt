package com.app.rachmad.movie.tv

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.rachmad.movie.R
import com.app.rachmad.movie.`object`.MovieData
import com.app.rachmad.movie.`object`.TvBaseData
import com.app.rachmad.movie.`object`.TvData

const val ARG_TYPE = "Type"
const val ARG_DATA = "Data"
class TvItemFragment : Fragment() {

    lateinit var cinemaType: String
    var data: TvBaseData? = null
    private var listener: OnTvClickListener? = null
    lateinit var adapter: TvItemRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            cinemaType = it.getString(ARG_TYPE, "")
            data = it.getSerializable(ARG_DATA) as TvBaseData

            adapter = TvItemRecyclerViewAdapter(data?.results, listener)
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tv_item_list, container, false)

        if (view is RecyclerView) {
            view.layoutManager = LinearLayoutManager(context)
            view.adapter = adapter
        }
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
        fun newInstance(type: String) =
                TvItemFragment().apply {
                    arguments = Bundle().apply {
                        putString(ARG_TYPE, type)
                    }
                }
    }
}
