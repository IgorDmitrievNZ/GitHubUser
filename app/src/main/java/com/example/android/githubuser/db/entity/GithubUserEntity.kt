package com.example.android.githubuser.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GithubUserEntity(
    @PrimaryKey val id: Long,
    val name: String,
    val userId: Long
)
