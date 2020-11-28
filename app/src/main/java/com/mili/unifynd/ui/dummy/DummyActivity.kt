package com.mili.unifynd.ui.dummy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.mili.unifynd.R
import com.mili.unifynd.common.GlobalConstants.EXTRA_POST
import com.mili.unifynd.data.local.Post
import com.mili.unifynd.databinding.ActivityDummyBinding

class DummyActivity : AppCompatActivity() {
    lateinit var binding: ActivityDummyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dummy)

        val post = intent.getParcelableExtra<Post>(EXTRA_POST)
        if (post != null) {
            binding.post = post
        } else {
            onBackPressed()
        }

    }
}