package com.shady.githubapp

import com.shady.data.models.Item
import com.shady.data.models.Owner
import com.shady.data.models.TrendingRawResponse
import com.shady.domain.entity.TrendingDomainModel
import com.shady.domain.entity.TrendingDominItem
import com.shady.githubapp.entities.TrendingViewItem
import com.shady.githubapp.helper.FakeExceptionTrendingUseCase
import com.shady.githubapp.helper.FakeThrowableTrendingUseCase
import com.shady.githubapp.helper.FakeTrendingUseCase
import com.shady.githubapp.helper.MainCoroutineRule
import com.shady.githubapp.helper.ViewModelTest
import com.shady.githubapp.mapper.TrendingViewEntityMapper
import io.mockk.coEvery
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test


@OptIn(ExperimentalCoroutinesApi::class)
class TrendingViewModelTest : ViewModelTest() {
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Test
    fun `when GetTrending is triggered with success value`() = runTest {
        // Given
        val fakeUseCase = FakeTrendingUseCase()
        val mViewModel = TrendingViewModel(
            getTrendingUseCase = fakeUseCase,
            dispatcher = testDispatcher,
            trendingViewEntityMapper = TrendingViewEntityMapper()
        )
        // domainEntity
        val trendingEntityItem =
            TrendingDominItem(
                "testUser",
                "testName",
                "testLng",
                "testStars",
                "testImage",
                "testUser"
            )
        val domainModel = TrendingDomainModel(listOf(trendingEntityItem))

        // viewEntity
        val trendingEntityItemView =
            TrendingViewItem(
                "testUser",
                "testUser",
                "testLng",
                "testStars",
                "testImage",
                "testName"
            )
        val viewModelModel = listOf(trendingEntityItemView)
        fakeUseCase.emit(domainModel)
        // When
        mainCoroutineRule.launch {
            mViewModel.intentChannel.send(TrendingIntent.GetTrending)
            coEvery { mViewModel.trendingViewState.value } returns TrendingViewState(
                viewModelModel,
                true,
                error = null
            )
        }
        // Then
        assertEquals(viewModelModel, mViewModel.trendingViewState.value.trendingInfo)
        assertEquals(null, mViewModel.trendingViewState.value.error?.message)
        assertEquals(false, mViewModel.trendingViewState.value.isLoading)
    }

    @Test()
    fun `when GetTrending is triggered with error throwable`() = runBlocking {
        // Given
        val throwable = Throwable("error")
        val fakeUseCase = FakeThrowableTrendingUseCase()
        fakeUseCase.setThrowable(throwable)
        fakeUseCase.emit(throwable)
        val mViewModel = TrendingViewModel(
            getTrendingUseCase = fakeUseCase, dispatcher = testDispatcher,
            trendingViewEntityMapper = TrendingViewEntityMapper()
        )
        // When
        mainCoroutineRule.launch {
            mViewModel.intentChannel.send(TrendingIntent.GetTrending)
        }
        // Then
        assertEquals(throwable, mViewModel.trendingViewState.value.error)
        assertEquals(true, mViewModel.trendingViewState.value.isLoading)
        assertEquals(null, mViewModel.trendingViewState.value.trendingInfo)
    }

    @Test()
    fun `when GetTrending is triggered with error exception`() = runBlocking {
        // Given
        val exception = Exception("error")
        val fakeUseCase = FakeExceptionTrendingUseCase()
        fakeUseCase.setException(exception)
        val trendingEntityItem =
            Item("testName", "testDes", "testLng", "testStars", Owner("testImage", "testUser"))
        val trendingResponse = TrendingRawResponse(listOf(trendingEntityItem))
        fakeUseCase.emit(trendingResponse)
        val mViewModel = TrendingViewModel(
            getTrendingUseCase = fakeUseCase, dispatcher = testDispatcher,
            trendingViewEntityMapper = TrendingViewEntityMapper()
        )
        // When
        mainCoroutineRule.launch {
            mViewModel.intentChannel.send(TrendingIntent.GetTrending)
        }
        // Then
        assertEquals(exception, mViewModel.trendingViewState.value.error)
        assertEquals(false, mViewModel.trendingViewState.value.isLoading)
        assertEquals(null, mViewModel.trendingViewState.value.trendingInfo)
    }
}
