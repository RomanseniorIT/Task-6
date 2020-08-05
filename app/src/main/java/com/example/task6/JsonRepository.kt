package com.example.task6

import com.example.task6.data.Video
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import java.io.File
import java.io.InputStream

class JsonRepository : MainContract.MainRepository {
    override suspend fun getListOfVideos(): List<Video> {
        lateinit var json : String
        val inputStream: InputStream = File("data.json").inputStream()
        json = inputStream.bufferedReader().use{it.readText()}
        val jsonObj = JSONObject(json)
        val jsonArr = jsonObj.getJSONArray("item")
        val listOfVideos = mutableListOf<Video>()
        for(i in 0 until jsonArr.length()) {
            val jsonResultObj = jsonArr.getJSONObject(i)
            val titleAndName = jsonResultObj.getString("title")
            val titleAndNameList = titleAndName.split("|")
            val title = titleAndNameList[0].trim()
            val name = titleAndNameList[1].trim()

            val imageObj = jsonResultObj.getJSONObject("image")
            val imageUrl = imageObj.getString("url")

            val videoDurationObj = jsonResultObj.getJSONObject("duration")
            val videoDuration = videoDurationObj.getString("text")

            val video = Video(title, name, imageUrl, videoDuration)
            listOfVideos.add(video)
        }
        return withContext(Dispatchers.IO){ listOfVideos}
    }
}