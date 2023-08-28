package com.shady.domain.repo

import com.shady.domain.entity.TrendingDomainModel

interface TrendingRepo {
    suspend fun getTrendingFromRemote(): TrendingDomainModel?
}