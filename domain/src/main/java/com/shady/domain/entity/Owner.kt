package com.shady.domain.entity

import com.google.gson.annotations.SerializedName

data class Owner(
    @SerializedName("avatar_url")
    val imageProfile: String,
    @SerializedName("login")
    val userName: String,
)