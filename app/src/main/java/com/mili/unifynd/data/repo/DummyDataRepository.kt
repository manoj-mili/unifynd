package com.mili.unifynd.data.repo

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mili.unifynd.R
import com.mili.unifynd.data.local.Post
import org.json.JSONArray
import java.nio.charset.StandardCharsets


class DummyDataRepository(private val context: Context, private val gson: Gson) {
    private val posts = MutableLiveData<List<Post>>()

    init {
        val inputStream = context.resources.openRawResource(R.raw.dummy)
        val buffer = ByteArray(inputStream.available())
        inputStream.read(buffer)
        inputStream.close()
        val listOfPost = JSONArray(String(buffer, StandardCharsets.UTF_8))
        val listType = object : TypeToken<List<Post>>() {}.type
        val formattedPost = gson.fromJson<List<Post>>(listOfPost.toString(), listType)
        posts.value = formattedPost
    }

    fun getListOfPost(): LiveData<List<Post>> {
        return posts
    }


    fun calculateSecondLargestNumber(listOfNumbers: List<Int>): Int {
        var largest: Int = Int.MIN_VALUE
        var secondLargest: Int = Int.MIN_VALUE
        for(value in listOfNumbers) {
            if (value > largest) {
                secondLargest = largest
                largest = value
            } else if (value < largest && value > secondLargest) {
                secondLargest = value
            }
        }
        return secondLargest
    }

}