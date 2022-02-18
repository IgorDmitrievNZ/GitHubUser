package com.example.android.githubuser.db.dao

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.android.githubuser.db.entity.GithubUserEntity
import io.reactivex.rxjava3.core.Single

interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(user: GithubUserEntity)

    @Query("SELECT * FROM GithubUserEntity")
    fun getAll(): Single<List<GithubUserEntity>>
}