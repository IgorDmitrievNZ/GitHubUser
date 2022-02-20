package com.example.android.githubuser.domain.user_repository

import com.example.android.githubuser.db.dao.UserDao
import com.example.android.githubuser.db.entity.GithubUserEntity
import com.example.android.githubuser.domain.model.GithubUserModel
import com.example.android.githubuser.network.GithubApiService
import com.example.android.githubuser.network.NetworkStatus
import io.reactivex.rxjava3.core.Single

class GithubUsersRepo(private val githubApiService: GithubApiService,
                      private val userDao: UserDao,
                      private val networkStatus: NetworkStatus) : IGithubUsersRepository {

//    override fun getUsers(): Single<List<GithubUserModel>> {
//        return githubApiService.getUsers()
//    }

    override fun getUsers(): Single<List<GithubUserModel>> = networkStatus.isOnlineSingle()
        .flatMap { isOnline ->
            if (isOnline) {
                githubApiService.getUsers()
                    .flatMap { users ->
                        userDao.insert(
                            users.map {
                                GithubUserEntity(it.id, it.login, it.avatarUrl, it.reposUrl)
                            }
                        )
                        Single.just(users)
                    }
            } else {
                userDao.getAll()
                    .map { users ->
                        users.map { user ->
                            GithubUserModel(user.id, user.login, user.avatarUrl, user.reposUrl)
                        }
                    }
            }
        }

//    private val repositories =
//        (1..100).map { GithubUser("login $it") } //old data
//
//    fun getUsers() = repositories
}