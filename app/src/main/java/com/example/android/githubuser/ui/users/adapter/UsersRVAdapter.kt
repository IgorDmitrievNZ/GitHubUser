package com.example.android.githubuser.ui.users.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.githubuser.databinding.ItemUserBinding
import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.ui.base.ImageLoader


class UsersRVAdapter(
    private val imageLoader: ImageLoader<ImageView>,
    private val itemClickListener: (GithubUserModel) -> Unit
) : ListAdapter<GithubUserModel, UsersRVAdapter.UsersViewHolder>(GithubUserItemCallback) {

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

        fun showUser(githubUserModel: GithubUserModel) {
            binding.root.setOnClickListener { itemClickListener(githubUserModel) }
            binding.tvLogin.text = githubUserModel.login

            if (githubUserModel.avatarUrl != null) {
                imageLoader.loadInto(githubUserModel.avatarUrl, binding.userImage)
            }
        }
    }
}

object GithubUserItemCallback : DiffUtil.ItemCallback<GithubUserModel>() {

    override fun areItemsTheSame(oldItem: GithubUserModel, newItem: GithubUserModel): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: GithubUserModel, newItem: GithubUserModel): Boolean {
        return oldItem == newItem
    }

}