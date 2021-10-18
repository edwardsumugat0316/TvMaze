package com.android.tvmazeapplication.showInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.tvmazeapplication.R
import com.android.tvmazeapplication.adapter.EpisodeRecyclerAdapter
import com.android.tvmazeapplication.model.episode.EpisodeEntity
import kotlinx.android.synthetic.main.fragment_episodes.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class EpisodeFragment : Fragment() {

    private val viewModel: ShowInfoViewModel by viewModel { parametersOf(arguments?.getInt("ShowId",0)) }
    private var episodeItemList = mutableListOf<EpisodeEntity>()
    private val myAdapter: EpisodeRecyclerAdapter by lazy { EpisodeRecyclerAdapter(episodeItemList, requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_episodes, container, false)
        val episodeId = arguments?.getInt("ShowId",0)
        episodeListSetup(episodeId)
        return view
    }


    private fun episodeListSetup(showId: Int?){
        viewModel.episodesLiveData.observe(viewLifecycleOwner){
            episodeItemList.addAll(it)
            lifecycleScope.launch {
                withContext(Dispatchers.Main){
                    myAdapter.setItem(episodeItemList)
                    setupRecyclerview()
                }
            }
        }
        viewModel.episodeList(showId)
    }
    fun setupRecyclerview(){
        rv_episodes.layoutManager = LinearLayoutManager(activity)
        rv_episodes.adapter = myAdapter
    }
}