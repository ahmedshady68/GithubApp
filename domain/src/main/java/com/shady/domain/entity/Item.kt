package com.shady.domain.entity

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("full_name")
    val fullName: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("language")
    val language: String,
    @SerializedName("stargazers_count")
    val stargazersCount: String,
    @SerializedName("owner")
    val owner: Owner,
)