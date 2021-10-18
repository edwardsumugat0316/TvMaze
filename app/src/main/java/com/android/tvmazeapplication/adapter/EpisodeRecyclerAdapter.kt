package com.android.tvmazeapplication.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.android.tvmazeapplication.EpisodeInfoActivity.EpisodeInfoActivity
import com.android.tvmazeapplication.R
import com.android.tvmazeapplication.model.episode.EpisodeEntity
import com.bumptech.glide.Glide

class EpisodeRecyclerAdapter(var episodeItem: List<EpisodeEntity>, val context: Context): RecyclerView.Adapter<EpisodeRecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val episodeImage: ImageView = view.findViewById(R.id.iv_episode_photo)
        val episodeTitle: TextView = view.findViewById(R.id.tv_episode_name)
        val season: TextView = view.findViewById(R.id.tv_episode_season)
        val runtime: TextView = view.findViewById(R.id.tv_episode_runtime)
        val epNumber: TextView = view.findViewById(R.id.tv_episode_number)

        init {
            view.setOnClickListener {
                val position: Int = bindingAdapterPosition
                val epItemPos = episodeItem[position]
                val episodeId = epItemPos.id
                Toast.makeText(view.context, "You clicked this episode  $episodeId", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, EpisodeInfoActivity::class.java).apply {
                    putExtra("EpisodeId", episodeId)
                }
                context.startActivity(intent)
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeRecyclerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.episodes_recyclerview_item, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: EpisodeRecyclerAdapter.ViewHolder, position: Int) {
        val episodeItem = episodeItem[position]
        holder.episodeTitle.text = episodeItem.name
        holder.season.text = episodeItem.season.toString()
        holder.epNumber.text = episodeItem.number.toString()
        holder.runtime.text = episodeItem.runtime.toString()

        Glide.with(holder.episodeImage)
                .load(episodeItem.image)
                .into(holder.episodeImage)
    }

    override fun getItemCount(): Int {
        return episodeItem.size
    }

    fun setItem(items: List<EpisodeEntity>){
        episodeItem = items
        notifyDataSetChanged()
    }
}