package com.shady.githubapp.helper

import com.shady.domain.entity.TrendingDomainModel
import com.shady.domain.entity.TrendingDominItem
import com.shady.domain.usecase.GetTrendingParent
import kotlinx.coroutines.flow.MutableStateFlow

class FakeTrendingUseCase : GetTrendingParent {
    private val trendingEntityItem =
        TrendingDominItem("testName", "testDes", "testLng", "testStars", "testImage", "testUser")
    private val trendingResponse = TrendingDomainModel(listOf(trendingEntityItem))
    private var fakeFlow = MutableStateFlow(trendingResponse)

    suspend fun emit(value: TrendingDomainModel) = value.let { fakeFlow.emit(it) }

    override suspend operator fun invoke() = fakeFlow.value
}