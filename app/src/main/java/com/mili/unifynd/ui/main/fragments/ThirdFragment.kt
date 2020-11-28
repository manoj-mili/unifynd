package com.mili.unifynd.ui.main.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.mili.unifynd.databinding.FragmentThirdBinding
import com.mili.unifynd.ui.base.BaseFragment
import com.mili.unifynd.ui.main.SharedViewModel

class ThirdFragment : BaseFragment() {
    lateinit var binding: FragmentThirdBinding
    lateinit var viewModel: SharedViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentThirdBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        injector.inject(this)
        binding.viewModel = viewModel
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}