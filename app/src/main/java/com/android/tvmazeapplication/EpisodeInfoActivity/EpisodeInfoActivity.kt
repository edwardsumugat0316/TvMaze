package com.android.tvmazeapplication.EpisodeInfoActivity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.android.tvmazeapplication.R
import com.android.tvmazeapplication.base.BaseActivity
import com.android.tvmazeapplication.model.episode.EpisodeEntity
import com.android.tvmazeapplication.showInfo.EpisodeFragment
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.episodeinfo_activity.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class EpisodeInfoActivity: BaseActivity() {

   private val viewModel:EpisodeInfoViewModel by viewModel{ parametersOf(intent.getIntExtra("EpisodeId", 0))}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.episodeinfo_activity)

        intent.getIntExtra("EpisodeId", 0)
        setup()

        back_button.setOnClickListener {
            startActivity(Intent(this,EpisodeFragment::class.java))
        }
    }


    private fun setup(){
        viewModel.episodeInfo.observe(this){
            lifecycleScope.launch {
                withContext(Dispatchers.Main){
                    episodeInfoSetup(it)
                }
            }
        }
    }
    private fun episodeInfoSetup(episodeInfo: EpisodeEntity){
        tv_episode_title_activity.text = episodeInfo.name
        tv_number_activity.text = episodeInfo.number.toString()
        tv_runtime_activity.text = episodeInfo.runtime.toString()
        tv_season_activity.text = episodeInfo.season.toString()
        tv_epSummary_activity.text = episodeInfo.summary

        Glide.with(this)
                .load(episodeInfo.image)
                .into(iv_ep_photo)
    }
}