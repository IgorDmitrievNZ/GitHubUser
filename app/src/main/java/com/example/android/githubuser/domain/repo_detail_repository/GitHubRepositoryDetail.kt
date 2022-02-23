package com.example.android.githubuser.domain.repo_detail_repository

import com.example.android.githubuser.db.dao.ReposDao
import com.example.android.githubuser.db.entity.GithubRepoEntity
import com.example.android.githubuser.domain.model.GitHubRepoDetailModel
import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.domain.model.Owner
import com.example.android.githubuser.network.GithubApiService
import com.example.android.githubuser.network.NetworkStatus
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class GitHubRepositoryDetail @Inject constructor(
    private val githubApiService: GithubApiService,
    private val reposDao: ReposDao,
    private val networkStatus: NetworkStatus
) : IGitHubRepositoryDetail {

    override fun getReposDetails(user: GithubUserModel): Single<List<GitHubRepoDetailModel>> =
        networkStatus.isOnlineSingle()
            .flatMap { isOnline ->
                if (isOnline) {
                    githubApiService.getRepositories(user.reposUrl)
                        .flatMap { repos ->
                            reposDao.insert(repos.map {
                                GithubRepoEntity(
                                    it.id,
                                    it.name,
                                    it.owner.ownerId,
                                    it.description
                                )
                            })
                            Single.just(repos)
                        }
                } else {
                    reposDao.getAll(user.id)
                        .map { list ->
                            list.map { repo ->
                                GitHubRepoDetailModel(
                                    repo.id,
                                    repo.name,
                                    repo.description,
                                    0,
                                    Owner(repo.userId)
                                )
                            }
                        }
                }
            }

}