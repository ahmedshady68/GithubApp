package com.shady.githubapp.helper

import com.shady.domain.entity.Item
import com.shady.domain.entity.Owner
import com.shady.domain.entity.TrendingResponse
import com.shady.domain.usecase.GetTrendingParent
import kotlinx.coroutines.flow.MutableStateFlow

class FakeTrendingUseCase : GetTrendingParent {
    private val trendingEntityItem =
        Item("testName", "testDes", "testLng", "testStars", Owner("testImage", "testUser"))
    private val trendingResponse = TrendingResponse(listOf(trendingEntityItem))
    private var fakeFlow = MutableStateFlow(trendingResponse)

    suspend fun emit(value: TrendingResponse?) = value?.let { fakeFlow.emit(it) }

    override suspend operator fun invoke() = fakeFlow.value
}