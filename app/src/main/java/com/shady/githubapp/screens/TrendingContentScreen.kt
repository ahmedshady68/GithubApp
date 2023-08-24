package com.shady.githubapp.screens

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import com.shady.githubapp.TrendingViewState


@Composable
fun TrendingList(listState: TrendingViewState, retryOnClick: () -> Unit) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        if (listState.isLoading) {
            TrendingLoadingScreen()
        }
        listState.trendingInfo?.let {
            TrendingSuccessScreen(state = listState)
        }
        listState.error?.let {
            TrendingErrorScreen(retryOnClick = retryOnClick)
        }
    }
}