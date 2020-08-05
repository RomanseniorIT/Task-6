package com.example.task6

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task6.data.Video
import kotlinx.coroutines.launch

class VideoViewModel : ViewModel(), MainContract.MainModel {
    private val _items = MutableLiveData<List<Video>>()
    val items: LiveData<List<Video>> get() = _items
    val repository = JsonRepository()

    override fun loadData(): LiveData<List<Video>> {
        viewModelScope.launch {
            _items.value = repository.getListOfVideos()
        }
        return items
    }
}