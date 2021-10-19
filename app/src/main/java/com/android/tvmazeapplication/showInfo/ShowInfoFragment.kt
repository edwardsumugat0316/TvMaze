package com.android.tvmazeapplication.showInfo

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.android.tvmazeapplication.R
import com.android.tvmazeapplication.model.ShowEntity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.fragment_show_info.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf


class ShowInfoFragment : Fragment() {

    private val viewModel: ShowInfoViewModel by viewModel { parametersOf(arguments?.getInt("ShowId",0))}

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_show_info, container, false)
        val showId = arguments?.getInt("ShowId",0)
        setup(showId)
        return view
    }



    private fun setup(id: Int?){
        viewModel.showInfo.observe(viewLifecycleOwner){
            lifecycleScope.launch {
                withContext(Dispatchers.Main){
                    setupInfo(it)
                }
            }
        }
    }

    private fun setupInfo(showInfo: ShowEntity) {
        tv_movieTitle.text = showInfo.name
        tv_movieRating.text = showInfo.rating.toString()
        tv_movieStatus.text = showInfo.status
        tv_movieSummary.text = showInfo.summary

        Glide.with(this)
                .load(showInfo.image)
                .into(iv_showPhoto)
    }

}