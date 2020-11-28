package com.mili.unifynd.simpledi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.mili.unifynd.data.repo.DummyDataRepository
import com.mili.unifynd.ui.main.SharedViewModel

class CustomViewModelProvider(private val repository: DummyDataRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SharedViewModel::class.java)) {
            return SharedViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class ${modelClass.canonicalName}")

    }
}