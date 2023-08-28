package com.shady.githubapp

import com.shady.githubapp.entities.TrendingViewItem

data class TrendingViewState(
    val trendingInfo: List<TrendingViewItem>? = null,
    val isLoading: Boolean = false,
    val error: Throwable? = null,
)
