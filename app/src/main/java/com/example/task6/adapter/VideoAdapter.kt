package com.example.task6.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.task6.R
import com.example.task6.data.Video

class VideoAdapter : RecyclerView.Adapter<VideoViewHolder>() {
    private val items = mutableListOf<Video>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_item, null)
        return VideoViewHolder(view)

    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val listItem = items[position]
        holder.titleViewHolder.text = listItem.title
        holder.nameViewHolder.text = listItem.name
        holder.durationViewHolder.text = listItem.videoDuration
        Glide.with(holder.imageViewHolder.context)
            .load(listItem.imageUrl)
            .centerCrop()
            .placeholder(R.drawable.ic_download)
            .into(holder.imageViewHolder)
    }

    fun addItems(newItems: List<Video>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }

}