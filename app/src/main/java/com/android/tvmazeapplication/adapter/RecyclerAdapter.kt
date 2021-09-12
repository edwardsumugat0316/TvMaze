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
import com.android.tvmazeapplication.R
import com.android.tvmazeapplication.model.ShowEntity
import com.android.tvmazeapplication.showInfo.ShowInfoActivity
import com.bumptech.glide.Glide

class RecyclerAdapter(var items: List<ShowEntity>, val context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.iv_PhotoMovie)
        val title: TextView = view.findViewById(R.id. tv_title)
        val rating: TextView = view.findViewById(R.id.tv_rating)
        val id: TextView = view.findViewById(R.id.tv_pos)

        init {
            view.setOnClickListener {
                val position: Int = bindingAdapterPosition
                val itemPos= items[position]
                val showId= itemPos.id
                Toast.makeText(view.context, "You clicked this movie id $showId", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ShowInfoActivity::class.java).apply {
                    putExtra("ShowId", showId)
                }
                context.startActivity(intent)
            }
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(layoutInflater)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        val showItem = items[position]
        holder.title.text = showItem.name
        holder.rating.text = showItem.rating.toString()
        holder.id.text = showItem.id.toString()

        Glide.with(holder.image)
            .load(showItem.image)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItem(items: List<ShowEntity>){
        this.items = items
        notifyDataSetChanged()
    }
}