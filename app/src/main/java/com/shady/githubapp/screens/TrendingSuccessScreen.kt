package com.shady.githubapp.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.shady.githubapp.TrendingViewState
import com.shady.githubapp.composable.TrendingCard

@Composable
fun TrendingSuccessScreen(state: TrendingViewState) {
    state.trendingInfo?.let {
        LazyColumn {
            items(state.trendingInfo) { item ->
                TrendingCard(state = item)
            }
        }
    }
}