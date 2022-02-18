package com.example.android.githubuser.domain.repo_detail_repository

import com.example.android.githubuser.domain.model.GitHubRepoDetailModel
import io.reactivex.rxjava3.core.Single

interface IGitHubRepositoryDetail {
    fun getReposDetails(url: String): Single<List<GitHubRepoDetailModel>>
}