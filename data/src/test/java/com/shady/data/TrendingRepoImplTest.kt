package com.shady.data

import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.shady.data.mappers.TrendingMappper
import com.shady.data.models.Item
import com.shady.data.models.Owner
import com.shady.data.models.TrendingRawResponse
import com.shady.data.remote.ApiService
import com.shady.data.repo.TrendingRepoImpl
import com.shady.domain.entity.TrendingDomainModel
import com.shady.domain.entity.TrendingDominItem
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TrendingRepoImplTest {
    private val apiService: ApiService = mock()
    private val mapper: TrendingMappper = mock()
    private val repo = TrendingRepoImpl(apiService = apiService, mapper = mapper)

    @Test
    fun `should call getTrendingFromRemote from TrendingRepoImpl when calling getCities from repo `() {
        runBlocking {
            // Given
            val trendingEntityItem =
                TrendingDominItem(
                    "testUser",
                    "testUser",
                    "testLng",
                    "testStars",
                    "testImage",
                    "testName"
                )
            val domainModel = TrendingDomainModel(listOf(trendingEntityItem))
            // rawEntity
            val rawEntity =
                Item(
                    "testUser",
                    "testUser",
                    "testLng",
                    "testStars",
                    Owner(
                        "testImage",
                        "testName"
                    )
                )
            val viewModelModel = TrendingRawResponse(listOf(rawEntity))
            whenever(apiService.getTrending()).thenReturn(viewModelModel)
            // When
            val result = repo.getTrendingFromRemote()

            // Then
            assertEquals(domainModel, result)
            verify(mapper).apply(any())
        }
    }
}
