package com.shady.data.repo

import com.shady.data.remote.ApiService
import com.shady.domain.entity.TrendingResponse
import com.shady.domain.repo.TrendingRepo

class TrendingRepoImpl(private val apiService: ApiService) : TrendingRepo {
    override suspend fun getTrendingFromRemote(): TrendingResponse = apiService.getTrending()
}