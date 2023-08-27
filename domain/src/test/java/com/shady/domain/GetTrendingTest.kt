package com.shady.domain

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.shady.domain.repo.TrendingRepo
import com.shady.domain.usecase.GetTrending

import kotlinx.coroutines.runBlocking
import org.junit.Test

class GetTrendingTest {
    private val trendingRepo: TrendingRepo = mock()
    private val getTrendingUseCase = GetTrending(trendingRepo)

    @Test
    fun `calling getCitesList with empty string should getAllCities`() {
        runBlocking {
            // act
            getTrendingUseCase.invoke()
            // assert
            verify(trendingRepo).getTrendingFromRemote()
        }
    }
}
