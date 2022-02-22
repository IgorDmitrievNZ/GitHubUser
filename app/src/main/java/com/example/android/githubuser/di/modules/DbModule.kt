package com.example.android.githubuser.di.modules

import android.content.Context
import com.example.android.githubuser.db.GithubDatabase
import com.example.android.githubuser.db.dao.ReposDao
import com.example.android.githubuser.db.dao.UserDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DbModule {

    @Provides
    @Singleton
    fun db(context: Context): GithubDatabase {
        return GithubDatabase.getInstance(context)
    }

    @Provides
    @Singleton
    fun usersDao(db: GithubDatabase): UserDao {
        return db.userDao
    }

    @Provides
    @Singleton
    fun reposDao(db: GithubDatabase): ReposDao {
        return db.reposDao
    }
}