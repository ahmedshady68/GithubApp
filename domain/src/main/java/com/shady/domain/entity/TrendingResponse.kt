package com.shady.domain.entity

data class TrendingResponse(
    val incomplete_results: Boolean,
    val items: List<Item>,
    val total_count: Int
)