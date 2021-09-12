package com.android.tvmazeapplication.showInfo

import android.content.Context
import android.os.Bundle
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


    companion object{
//        const val ARG_showId = "ShowId"
//        @JvmStatic
//        fun newInstance(showId: Int): ShowInfoFragment {
//            val fragment = ShowInfoFragment()
//            val bundle = Bundle().apply {
//                putInt(ARG_showId, showId)
//            }
//            fragment.arguments = bundle
//            return fragment
//        }
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_show_info, container, false)
//        val showId = arguments?.getInt(ARG_showId)
        val activityData = arguments?.getInt("ShowId",0)
        setup(activityData)
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
//        tv_networkName.text = showInfo.network?.name
        tv_movieSummary.text = showInfo.summary

        Glide.with(this)
                .load(showInfo.image)
                .into(iv_showPhoto)
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }


    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

}