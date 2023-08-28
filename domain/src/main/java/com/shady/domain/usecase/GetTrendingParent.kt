package com.shady.domain.usecase

import com.shady.domain.entity.TrendingDomainModel

interface GetTrendingParent {
    suspend operator fun invoke(): TrendingDomainModel?
}
