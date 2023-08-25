package com.shady.githubapp

import com.shady.domain.entity.TrendingResponse

data class TrendingViewState(
    val trendingInfo: TrendingResponse? = null,
    val isLoading: Boolean = false,
    val error: Throwable? = null
)
