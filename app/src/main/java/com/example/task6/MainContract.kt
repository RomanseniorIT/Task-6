package com.example.task6

import androidx.lifecycle.LiveData
import com.example.task6.data.Video

interface MainContract {

    interface MainView {
        fun showView()
    }

    interface MainPresenter{
    }

    interface MainModel{
        fun loadData() : LiveData<List<Video>>
    }

    interface MainRepository{
        suspend fun getListOfVideos() : List<Video>
    }
}