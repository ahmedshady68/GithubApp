package com.shady.githubapp.ui.screens

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import com.shady.githubapp.ui.entities.TrendingViewState
import com.shady.githubapp.ui.composable.TrendingCard

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