package com.example.android.githubuser.di.modules

import com.example.android.githubuser.db.dao.ReposDao
import com.example.android.githubuser.db.dao.UserDao
import com.example.android.githubuser.domain.repo_detail_repository.GitHubRepositoryDetail
import com.example.android.githubuser.domain.repo_detail_repository.IGitHubRepositoryDetail
import com.example.android.githubuser.domain.user_repository.GithubUsersRepo
import com.example.android.githubuser.domain.user_repository.IGithubUsersRepository
import com.example.android.githubuser.network.GithubApiService
import com.example.android.githubuser.network.NetworkStatus
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {
    @Provides
    @Singleton
    fun usersRepo(
        apiService: GithubApiService,
        usersDao: UserDao,
        networkStatus: NetworkStatus
    ): IGithubUsersRepository {
        return GithubUsersRepo(apiService, usersDao, networkStatus)
    }

    @Provides
    @Singleton
    fun reposRepo(
        apiService: GithubApiService,
        reposDao: ReposDao,
        networkStatus: NetworkStatus
    ): IGitHubRepositoryDetail {
        return GitHubRepositoryDetail(apiService, reposDao, networkStatus)
    }
}