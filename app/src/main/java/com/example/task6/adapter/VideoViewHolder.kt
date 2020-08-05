package com.example.task6.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.task6.R

class VideoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val titleViewHolder = view.findViewById<TextView>(R.id.idTitle)
    val nameViewHolder = view.findViewById<TextView>(R.id.idName)
    val imageViewHolder = view.findViewById<ImageView>(R.id.idItemImageView)
    val durationViewHolder = view.findViewById<TextView>(R.id.idVideoDuration)
}