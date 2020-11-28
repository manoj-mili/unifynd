package com.mili.unifynd.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.mili.unifynd.data.local.Post
import com.mili.unifynd.databinding.FragmentFirstBinding
import com.mili.unifynd.ui.base.BaseFragment
import com.mili.unifynd.ui.main.SharedViewModel
import com.mili.unifynd.ui.main.adapter.ItemSelect
import com.mili.unifynd.ui.main.adapter.RvAdapter

class FirstFragment : BaseFragment(),ItemSelect {
    lateinit var rvAdapter: RvAdapter
    lateinit var binding: FragmentFirstBinding
    lateinit var viewModel: SharedViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        injector.inject(this)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.adapter = rvAdapter

        observeChanges()

    }

    private fun observeChanges() {
        viewModel.getPosts().observe(this, Observer {
            if (it != null && it.isNotEmpty()) {
                rvAdapter.setData(it)
            }
        })
    }

    override fun onItemSelect(post: Post) {
        viewModel.setSelectedPost(post)
    }
}