package com.example.android.githubuser.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.githubuser.databinding.ItemUserBinding
import com.example.android.githubuser.model.GithubUser
import com.example.android.githubuser.ui.base.ImageLoader


class UsersRVAdapter(
    private val imageLoader: ImageLoader<ImageView>,
    private val itemClickListener: (GithubUser) -> Unit
) :
    ListAdapter<GithubUser, UsersRVAdapter.UsersViewHolder>(GithubUserItemCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersViewHolder {
        return UsersViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
        holder.showUser(currentList[position])
    }

    inner class UsersViewHolder(private val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun showUser(githubUser: GithubUser) {
            binding.root.setOnClickListener { itemClickListener(githubUser) }
            binding.tvLogin.text = githubUser.login

            if (githubUser.avatarUrl != null) {
                imageLoader.loadInto(githubUser.avatarUrl, binding.userImage)
            }
        }
    }
}

object GithubUserItemCallback : DiffUtil.ItemCallback<GithubUser>() {

    override fun areItemsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GithubUser, newItem: GithubUser): Boolean {
        return oldItem == newItem
    }

}