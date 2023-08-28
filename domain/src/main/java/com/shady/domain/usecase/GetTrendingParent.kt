package com.shady.domain.usecase

import com.shady.domain.entity.TrendingResponse

interface GetTrendingParent {
    suspend operator fun invoke(): TrendingResponse?
}
