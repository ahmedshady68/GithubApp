package com.shady.githubapp.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.shady.githubapp.TrendingViewState


@Composable
fun TrendingList(state: TrendingViewState, retry: () -> Unit) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        if (state.isLoading) {
            TrendingLoadingScreen()
        }
        state.trendingInfo?.let {
            TrendingSuccessScreen(state = state)
        }
        state.error?.let {
            TrendingErrorScreen(retry)
        }
    }
}