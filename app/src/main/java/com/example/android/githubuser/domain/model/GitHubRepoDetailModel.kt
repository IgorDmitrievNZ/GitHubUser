package com.example.android.githubuser.domain.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GitHubRepoDetailModel(
    @Expose
    val name: String,

    @Expose
    val description: String?,

    @Expose
    val forksCount: Int
) : Parcelable
