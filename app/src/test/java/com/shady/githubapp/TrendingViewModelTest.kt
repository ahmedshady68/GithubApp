package com.shady.githubapp

import com.shady.domain.entity.Item
import com.shady.domain.entity.Owner
import com.shady.domain.entity.TrendingResponse
import com.shady.domain.repo.TrendingRepo
import com.shady.domain.usecase.GetTrending
import com.shady.githubapp.helper.ViewModelTest
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import io.mockk.impl.annotations.OverrideMockKs
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class TrendingViewModelTest : ViewModelTest() {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @MockK(relaxUnitFun = true)
    private lateinit var trendingRepoImpl: TrendingRepo

    @OverrideMockKs
    private lateinit var getTrending: GetTrending

    @OverrideMockKs
    private lateinit var viewModel: TrendingViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    // success scenario..
    @Test
    fun `when GetTrending is triggered with success value`() = runTest {
        val trendingEntityItem = Item("Ahmed", "", "", "", Owner("", ""))
        val trendingResponse = TrendingResponse(listOf(trendingEntityItem))
        coEvery { viewModel.getTrendingUseCase() } answers { trendingResponse }
        mainCoroutineRule.launch {
            viewModel.intentChannel.send(TrendingIntent.GetTrending)
        }
        assertEquals(trendingResponse, getCurrentViewState().value.trendingInfo)
        coVerify { viewModel.getTrendingUseCase() }
    }

    @Test
    fun `when GetTrending is triggered with error state`() = runTest {
        mainCoroutineRule.launch {
            viewModel.intentChannel.send(TrendingIntent.GetTrending)
        }
        val trendingEntityItem = Item("Ahmed", "", "", "", Owner("", ""))
        val trendingResponse = TrendingResponse(listOf(trendingEntityItem))
        coEvery { viewModel.getTrendingUseCase() } returns trendingResponse
        coEvery { trendingRepoImpl.getTrendingFromRemote() } returns trendingResponse
        testDispatcher.scheduler.advanceUntilIdle()
        assertNotNull(getCurrentViewState().value.error)
        assertEquals(false, getCurrentViewState().value.isLoading)
        assertNull(getCurrentViewState().value.trendingInfo)
    }


    @Test
    fun `when GetTrending is triggered with error throwable`() = runBlocking {
        val throwable = Throwable(message = "error")

        coEvery { viewModel.getTrendingUseCase() } answers { throw throwable }

        mainCoroutineRule.launch {
            viewModel.intentChannel.send(TrendingIntent.GetTrending)
        }
        assertEquals(throwable, getCurrentViewState().value.error)
        coVerify { viewModel.getTrendingUseCase() }
    }

    private fun getCurrentViewState() = viewModel.trendingViewState
}
