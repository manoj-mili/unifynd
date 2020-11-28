package com.mili.unifynd.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mili.unifynd.data.local.Post
import com.mili.unifynd.databinding.ItemDataBinding

class RvAdapter(private val itemSelect: ItemSelect) :
    RecyclerView.Adapter<RvAdapter.ViewHolder>() {
    lateinit var posts: List<Post>

    class ViewHolder(private val binding: ItemDataBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(post: Post, itemSelect: ItemSelect) {
            binding.post = post
            binding.listener = itemSelect
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        if (posts.isNullOrEmpty()) {
            return 0
        }
        return posts.size
    }

    fun setData(it: List<Post>) {
        this.posts = it
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(posts[position], itemSelect = itemSelect)
    }
}