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
import com.android.tvmazeapplication.model.ShowStructureItem
import com.android.tvmazeapplication.showInfo.ShowInfoActivity
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.recycler_view_item.view.*

class RecyclerAdapter( var items: List<ShowStructureItem>, val context: Context): RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    inner class ViewHolder(view:View): RecyclerView.ViewHolder(view){
        val image: ImageView = view.findViewById(R.id.iv_PhotoMovie)
        val title: TextView = view.findViewById(R.id. tv_title)
        val rating: TextView = view.findViewById(R.id.tv_rating)

        init {
            view.setOnClickListener {
                val position: Int = bindingAdapterPosition
                val itemPos= items[position]
                val title = itemPos.name
                Toast.makeText(view.context, "You clicked this movie $title", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, ShowInfoActivity::class.java).apply {
                    putExtra("ShowInfo",title)
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

        Glide.with(holder.image)
            .load(showItem.image.medium)
            .into(holder.image)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItem(items: List<ShowStructureItem>){
        this.items = items
        notifyDataSetChanged()
    }
}