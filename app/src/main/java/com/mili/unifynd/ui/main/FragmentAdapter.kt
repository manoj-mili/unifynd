package com.mili.unifynd.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.mili.unifynd.ui.main.fragments.FirstFragment
import com.mili.unifynd.ui.main.fragments.SecondFragment
import com.mili.unifynd.ui.main.fragments.ThirdFragment

class FragmentAdapter(fragmentActivity: FragmentActivity, private val count: Int) :
    FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int {
        return count
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> FirstFragment()
            1 -> SecondFragment()
            2 -> ThirdFragment()
            else -> throw IllegalArgumentException("No Fragment Found for the Position $position")
        }
    }
}