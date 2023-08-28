package com.shady.githubapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shady.domain.entity.TrendingDomainModel
import com.shady.domain.usecase.GetTrendingParent
import com.shady.githubapp.entities.TrendingIntent
import com.shady.githubapp.entities.TrendingViewState
import com.shady.githubapp.mapper.TrendingViewEntityMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor(
    private val getTrendingUseCase: GetTrendingParent,
    private val trendingViewEntityMapper: TrendingViewEntityMapper,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) :
    ViewModel() {
    val intentChannel = Channel<TrendingIntent>(Channel.UNLIMITED)

    private val _trendingViewState = MutableStateFlow(TrendingViewState())
    val trendingViewState: StateFlow<TrendingViewState> get() = _trendingViewState

    private var trendingJob: Job? = null

    private val exceptionHandler: CoroutineExceptionHandler =
        CoroutineExceptionHandler { _, throwable ->
            viewModelScope.launch {
                _trendingViewState.emit(
                    trendingViewState.value.copy(
                        error = throwable
                    )
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
        cancelActiveJobs()
        trendingJob = viewModelScope.launch(exceptionHandler + dispatcher) {
            _trendingViewState.emit(
                trendingViewState.value.copy(
                    isLoading = true,
                    error = null
                )
            )
            _trendingViewState.emit(
                try {
                    trendingViewState.value.copy(
                        trendingInfo =
                        mapToViewState(getTrendingUseCase()),
                        isLoading = false,
                        error = null
                    )
                } catch (exception: Exception) {
                    _trendingViewState.value.copy(
                        trendingInfo = null,
                        isLoading = false,
                        error = exception
                    )
                }
            )
        }
    }

    private fun cancelActiveJobs() {
        trendingJob?.cancelChildren()
        trendingJob?.cancel()
    }

    private fun mapToViewState(it: TrendingDomainModel?) = trendingViewEntityMapper.apply(it)
}