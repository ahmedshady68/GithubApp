package com.shady.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.shady.data.remote.ApiService
import com.shady.data.repo.TrendingRepoImpl
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TrendingRepoImplTest {
    private val apiService: ApiService = mock()
    private val repo = TrendingRepoImpl(apiService)

    @Test
    fun `should call getCitiesRaw from localDataSource when calling getCities from repo `() {
        runBlocking {
            // act
            repo.getTrendingFromRemote()
            //verify
            verify(apiService).getTrending()
        }
    }
}
