package com.shady.domain.repo

import com.shady.domain.entity.TrendingResponse

interface TrendingRepo {
    suspend fun getTrendingFromRemote(): TrendingResponse?
}