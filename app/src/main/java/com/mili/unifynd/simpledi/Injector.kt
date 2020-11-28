package com.mili.unifynd.simpledi

import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.mili.unifynd.BaseApp
import com.mili.unifynd.data.repo.DummyDataRepository
import com.mili.unifynd.ui.main.FragmentAdapter
import com.mili.unifynd.ui.main.MainActivity
import com.mili.unifynd.ui.main.SharedViewModel
import com.mili.unifynd.ui.main.adapter.RvAdapter
import com.mili.unifynd.ui.main.fragments.FirstFragment
import com.mili.unifynd.ui.main.fragments.SecondFragment
import com.mili.unifynd.ui.main.fragments.ThirdFragment

class Injector(private val app: BaseApp) {
    val gson = Gson()
    private fun provideViewModel(): CustomViewModelProvider {
        return CustomViewModelProvider(DummyDataRepository(app, gson = gson))
    }

    fun inject(mainActivity: MainActivity) {
        mainActivity.viewModel =
            ViewModelProvider(mainActivity, provideViewModel()).get(SharedViewModel::class.java)
        mainActivity.fragmentAdapter = FragmentAdapter(mainActivity, 3)
    }

    fun inject(fragment: FirstFragment) {
        fragment.viewModel = ViewModelProvider(
            fragment.requireActivity(), provideViewModel()
        ).get(SharedViewModel::class.java)

        fragment.rvAdapter = RvAdapter(fragment)
    }

    fun inject(fragment: SecondFragment) {
        fragment.viewModel = ViewModelProvider(
            fragment.requireActivity(), provideViewModel()
        ).get(SharedViewModel::class.java)

        fragment.rvAdapter = RvAdapter(fragment)
    }

    fun inject(fragment: ThirdFragment) {
        fragment.viewModel = ViewModelProvider(
            fragment.requireActivity(), provideViewModel()
        ).get(SharedViewModel::class.java)
    }


}