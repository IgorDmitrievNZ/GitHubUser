package com.example.android.githubuser.ui.repos.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.android.githubuser.databinding.ItemRepositoriesBinding
import com.example.android.githubuser.domain.model.GitHubRepoDetailModel

class ReposAdapter(private val itemClickListener: (GitHubRepoDetailModel) -> Unit) :
    ListAdapter<GitHubRepoDetailModel, ReposAdapter.ReposViewHolder>(GithubRepoItemCallback) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ReposViewHolder {

        return ReposViewHolder(
            ItemRepositoriesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ReposAdapter.ReposViewHolder, position: Int) {
        holder.showRepo(currentList[position])
    }

    inner class ReposViewHolder(private val binding: ItemRepositoriesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun showRepo(githubRepoModel: GitHubRepoDetailModel) {
            binding.root.setOnClickListener { itemClickListener(githubRepoModel) }
            binding.repoName.text = githubRepoModel.name
            binding.description.text = githubRepoModel.description
            binding.description.isVisible = githubRepoModel.description != null
        }
    }
}

object GithubRepoItemCallback : DiffUtil.ItemCallback<GitHubRepoDetailModel>() {

    override fun areItemsTheSame(
        oldItem: GitHubRepoDetailModel,
        newItem: GitHubRepoDetailModel
    ): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(
        oldItem: GitHubRepoDetailModel,
        newItem: GitHubRepoDetailModel
    ): Boolean {
        return oldItem == newItem
    }

}