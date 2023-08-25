package com.shady.githubapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shady.domain.usecase.GetTrending
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor(
    private val getTrendingUseCase: GetTrending,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) :
    ViewModel() {
    val intentChannel = Channel<TrendingIntent>(Channel.UNLIMITED)
    var trendingViewState by mutableStateOf(TrendingViewState())

    private val exceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            viewModelScope.launch {
                trendingViewState.copy(
                    error = throwable
                )
            }
        }

    init {
        processTrending()
    }

    // process from activity
    private fun processTrending() {
        viewModelScope.launch {
            intentChannel.consumeAsFlow().collect {
                when (it) {
                    is TrendingIntent.GetTrending -> reduceTrending()
                }
            }
        }
    }

    // reduce to activity
    private fun reduceTrending() {
        viewModelScope.launch(exceptionHandler + dispatcher) {
            trendingViewState = trendingViewState.copy(
                isLoading = true,
                error = null
            )
            trendingViewState = try {
                trendingViewState.copy(
                    trendingInfo = getTrendingUseCase(),
                    isLoading = false,
                    error = null
                )
            } catch (error: Exception) {
                trendingViewState.copy(
                    trendingInfo = null,
                    isLoading = false,
                    error = error
                )
            }
        }
    }
}