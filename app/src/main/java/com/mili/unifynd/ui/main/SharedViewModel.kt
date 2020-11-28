package com.mili.unifynd.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mili.unifynd.data.local.Post
import com.mili.unifynd.data.repo.DummyDataRepository

class SharedViewModel(private val repository: DummyDataRepository) : ViewModel() {
    val inputNumber = MutableLiveData("")
    val allInputNumberList = MutableLiveData("NA")
    val secondLargestNumber = MutableLiveData("At least 2 Numbers Required")
    private val selectedPost = MutableLiveData<Post>()
    private val listOfNumbers: MutableList<Int> = mutableListOf()

    fun getPosts(): LiveData<List<Post>> {
        return repository.getListOfPost()
    }

    fun getSelectedPost(): LiveData<Post> {
        return selectedPost
    }

    fun setSelectedPost(post: Post) {
        selectedPost.value = post
    }

    fun onAddNewNumber() {
        if (inputNumber.value?.length == 0) {
            return
        }
        if (listOfNumbers.size == 0) {
            allInputNumberList.value = inputNumber.value
        } else {
            allInputNumberList.value = allInputNumberList.value + ", " + inputNumber.value
        }

        inputNumber.value?.let { listOfNumbers.add(it.toInt()) }

        if (listOfNumbers.size > 1) {
            secondLargestNumber.value =
                repository.calculateSecondLargestNumber(listOfNumbers).toString()
        } else {
            secondLargestNumber.value = "At least 2 Numbers Required"
        }
        inputNumber.value = ""
    }

}