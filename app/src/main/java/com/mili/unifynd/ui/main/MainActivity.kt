package com.mili.unifynd.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.google.android.material.tabs.TabLayoutMediator
import com.mili.unifynd.R
import com.mili.unifynd.common.GlobalConstants.EXTRA_POST
import com.mili.unifynd.databinding.ActivityMainBinding
import com.mili.unifynd.ui.base.BaseActivity
import com.mili.unifynd.ui.dummy.DummyActivity

class MainActivity : BaseActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: SharedViewModel
    lateinit var fragmentAdapter: FragmentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this

        injector.inject(this)

        binding.vpSlider.adapter = fragmentAdapter
        binding.vpSlider.isUserInputEnabled = false;
        TabLayoutMediator(binding.tbViews, binding.vpSlider) { tab, position ->
            tab.text = "Tab ${position + 1}"
        }.attach()
        observeChanges()
    }

    private fun observeChanges() {
        viewModel.getSelectedPost().observe(this, Observer {
            if (it != null) {
                val intent = Intent(this, DummyActivity::class.java)
                intent.putExtra(EXTRA_POST, it)
                startActivity(intent)
            }
        })
    }
}