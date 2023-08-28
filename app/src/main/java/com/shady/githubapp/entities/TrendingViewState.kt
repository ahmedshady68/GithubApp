package com.shady.githubapp.entities

data class TrendingViewState(
    val trendingInfo: List<TrendingViewItem>? = null,
    val isLoading: Boolean = false,
    val error: Throwable? = null,
)
