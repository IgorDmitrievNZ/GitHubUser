package com.example.android.githubuser.domain.repo_detail_repository

import com.example.android.githubuser.domain.model.GitHubRepoDetailModel
import com.example.android.githubuser.domain.model.GithubUserModel
import io.reactivex.rxjava3.core.Single

interface IGitHubRepositoryDetail {
    fun getReposDetails(userModel: GithubUserModel): Single<List<GitHubRepoDetailModel>>
}