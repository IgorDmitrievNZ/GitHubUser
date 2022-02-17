package com.example.android.githubuser.domain.repo_detail_repository

import com.example.android.githubuser.model.GitHubRepoDetailModel
import com.example.android.githubuser.network.ApiHolder.githubApiService
import io.reactivex.rxjava3.core.Single

class GitHubRepositoryDetail() : IGitHubRepositoryDetail {

    override fun getReposDetails(url: String): Single<List<GitHubRepoDetailModel>> {
        return githubApiService.getRepositories(url)
    }

}