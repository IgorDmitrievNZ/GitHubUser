package com.example.android.githubuser.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.android.githubuser.db.dao.ReposDao
import com.example.android.githubuser.db.dao.UserDao
import com.example.android.githubuser.db.entity.GithubRepoEntity
import com.example.android.githubuser.db.entity.GithubUserEntity

@Database(
    entities = [GithubUserEntity::class, GithubRepoEntity::class],
    version = 1,
)
abstract class GithubDatabase : RoomDatabase() {

    abstract val userDao: UserDao
    abstract val reposDao: ReposDao

    companion object {

        private const val DB_NAME = "database.db"

        private var instance: GithubDatabase? = null

        fun getInstance(context: Context): GithubDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, GithubDatabase::class.java, DB_NAME)
                    .build()
            }

            return instance!!
        }
    }
}