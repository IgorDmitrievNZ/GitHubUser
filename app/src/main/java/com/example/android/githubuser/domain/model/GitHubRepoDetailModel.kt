package com.example.android.githubuser.domain.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class GitHubRepoDetailModel(

    @Expose
    val id: Long,

    @Expose
    val name: String,

    @Expose
    val description: String?,

    @Expose
    val forksCount: Int,

    @Expose
    val owner: Owner
)

data class Owner(
    @SerializedName("id")
    @Expose
    val ownerId: Long,
)
