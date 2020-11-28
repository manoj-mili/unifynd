package com.mili.unifynd.ui.base

import androidx.fragment.app.Fragment
import com.mili.unifynd.BaseApp

open class BaseFragment : Fragment() {
    val injector by lazy {
        (requireActivity().application as BaseApp).appInjector
    }
}