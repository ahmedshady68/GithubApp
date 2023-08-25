package com.shady.githubapp

import com.shady.domain.entity.Item
import com.shady.domain.entity.Owner
import com.shady.domain.entity.TrendingResponse
import com.shady.domain.usecase.GetTrending
import com.shady.githubapp.helper.ViewModelTest
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.MockK
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class TrendingViewModelTest : ViewModelTest() {
    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private val dispatcher = StandardTestDispatcher()

    @MockK
    lateinit var trendingUseCase: GetTrending

    private lateinit var viewModel: TrendingViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
    }

    private fun produceViewModel(viewState: TrendingViewState = TrendingViewState()): TrendingViewModel {
        val viewModel = TrendingViewModel(trendingUseCase)

        viewModel.trendingViewState = viewState
        return viewModel
    }

    private fun getCurrentViewState() = viewModel.trendingViewState

    @Test
    fun `when GetTrending is triggered with empty value`() {
        viewModel = produceViewModel(
            viewState = TrendingViewState()
        )
        mainCoroutineRule.launch {
            viewModel.intentChannel.send(TrendingIntent.GetTrending)
        }
        dispatcher.scheduler.advanceUntilIdle()
        assertEquals(false, getCurrentViewState().isLoading)
    }

    @Test
    fun `when GetTrending is triggered with non-empty value`() = runTest {
        viewModel = produceViewModel(
            viewState = TrendingViewState(
                TrendingResponse(
                    listOf(
                        Item(
                            "Ahmed Shady",
                            "des",
                            "lang",
                            "555",
                            Owner("url", "Ahmed")
                        )
                    )
                )
            )
        )
        dispatcher.scheduler.advanceUntilIdle()
        mainCoroutineRule.launch {
            viewModel.intentChannel.send(TrendingIntent.GetTrending)
        }

        assertEquals("Ahmed Shady", getCurrentViewState().trendingInfo?.items?.get(0)?.fullName)
        assertNotNull(getCurrentViewState().trendingInfo)
        assertEquals(true, getCurrentViewState().isLoading)
        assertNull(getCurrentViewState().error)
    }

    @Test
    fun `when GetTrending is triggered with error value`() = runTest {

        viewModel = produceViewModel(
            viewState = TrendingViewState(
                error = Throwable()
            )
        )
        mainCoroutineRule.launch {
            viewModel.intentChannel.send(TrendingIntent.GetTrending)
        }

        assertEquals(null, getCurrentViewState().trendingInfo?.items?.get(0)?.fullName)
    }

    @Test

    fun `when GetTrending is triggered with error state`() = runTest {

        viewModel = produceViewModel(
            viewState = TrendingViewState(
                error = Throwable()
            )
        )
        mainCoroutineRule.launch {
            viewModel.intentChannel.send(TrendingIntent.GetTrending)
        }
        dispatcher.scheduler.advanceUntilIdle()
        assertNotNull(getCurrentViewState().error)
        assertEquals(false, getCurrentViewState().isLoading)
        assertNull(getCurrentViewState().trendingInfo)
    }
}