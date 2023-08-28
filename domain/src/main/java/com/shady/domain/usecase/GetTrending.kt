package com.shady.domain.usecase

import com.shady.domain.repo.TrendingRepo

class GetTrending(private val trendingRepo: TrendingRepo) : GetTrendingParent {
    override suspend operator fun invoke() = trendingRepo.getTrendingFromRemote()
}