package com.example.android.githubuser.di.modules

import com.example.android.githubuser.domain.repo_detail_repository.GitHubRepositoryDetail
import com.example.android.githubuser.domain.repo_detail_repository.IGitHubRepositoryDetail
import com.example.android.githubuser.domain.user_repository.GithubUsersRepo
import com.example.android.githubuser.domain.user_repository.IGithubUsersRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
interface RepositoryModule {

    @Binds
    @Singleton
    fun provideUserRepository(impl: GithubUsersRepo): IGithubUsersRepository

    @Binds
    @Singleton
    fun provideRepoRepository(impl: GitHubRepositoryDetail): IGitHubRepositoryDetail


    /**
     * After we added @Binds these functions are not required any more
     * Only keep them here to see the difference
     */
//    @Provides
//    @Singleton
//    fun usersRepo(
//        apiService: GithubApiService,
//        usersDao: UserDao,
//        networkStatus: NetworkStatus
//    ): IGithubUsersRepository {
//        return GithubUsersRepo(apiService, usersDao, networkStatus)
//    }
//
//    @Provides
//    @Singleton
//    fun reposRepo(
//        apiService: GithubApiService,
//        reposDao: ReposDao,
//        networkStatus: NetworkStatus
//    ): IGitHubRepositoryDetail {
//        return GitHubRepositoryDetail(apiService, reposDao, networkStatus)
//    }
}