package com.shady.data.repo

import com.shady.data.mappers.TrendingMappper
import com.shady.data.remote.ApiService
import com.shady.domain.entity.TrendingDomainModel
import com.shady.domain.repo.TrendingRepo

class TrendingRepoImpl(
    private val apiService: ApiService,
    private val mapper: TrendingMappper,
) : TrendingRepo {
    override suspend fun getTrendingFromRemote(): TrendingDomainModel = apiService.getTrending().items.let {
        mapper.apply(it)
    }
}