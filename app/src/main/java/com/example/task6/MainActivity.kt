package com.example.task6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.task6.adapter.VideoAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val itemAdapter = VideoAdapter()
private val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
    private val videoViewModel by viewModels<VideoViewModel>()
    private val videoViewModelItems = videoViewModel.loadData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        videoViewModelItems.observe(this, Observer {
            it ?: return@Observer
            itemAdapter.addItems(it)
        })
    }
}
