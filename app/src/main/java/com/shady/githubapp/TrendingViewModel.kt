package com.shady.githubapp

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shady.domain.entity.TrendingResponse
import com.shady.domain.usecase.GetTrending
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TrendingViewModel @Inject constructor(private val getTrendingUseCase: GetTrending) :
    ViewModel() {
    private val _trending: MutableStateFlow<TrendingResponse?> = MutableStateFlow(null)
    val trending: StateFlow<TrendingResponse?> = _trending
    fun getTrending() {
        viewModelScope.launch {
            try {
                _trending.value = getTrendingUseCase()
            } catch (e: Exception) {
                Log.e("trending view model", e.message.toString())
            }
        }
    }
}