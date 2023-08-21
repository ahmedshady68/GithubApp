package com.shady.domain.usecase

import com.shady.domain.repo.TrendingRepo

class GetTrending(private val trendingRepo: TrendingRepo) {
    suspend operator fun invoke() = trendingRepo.getTrendingFromRemote()
}