package com.shady.githubapp

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shady.domain.usecase.GetTrending
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor(private val getTrendingUseCase: GetTrending) :
    ViewModel() {
    val intentChannel = Channel<TrendingIntent>(Channel.UNLIMITED)
    var trendingViewState by mutableStateOf(TrendingViewState())
        private set

    init {
        processTrending()
    }

    // process from activity
    private fun processTrending() {
        viewModelScope.launch {
            trendingViewState = trendingViewState.copy(
                isLoading = true,
                error = null
            )
            intentChannel.consumeAsFlow().collect {
                when (it) {
                    is TrendingIntent.GetTrending -> reduceTrending()
                }
            }
        }
    }

    // reduce to activity
    private fun reduceTrending() {
        viewModelScope.launch {
            trendingViewState = try {
                trendingViewState.copy(
                    trendingInfo = getTrendingUseCase(),
                    isLoading = false,
                    error = null
                )
            } catch (e: Exception) {
                trendingViewState.copy(
                    trendingInfo = null,
                    isLoading = false,
                    error = e.message
                )
            }
        }
    }
}