package com.shady.githubapp.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shady.githubapp.entities.TrendingViewState
import com.shady.githubapp.composable.ShimmerListItem

@Composable
fun TrendingList(listState: TrendingViewState, retryOnClick: () -> Unit) {
    listState.isLoading.also { showShimmerLoading ->
        ShimmerLoading(showShimmerLoading)
    }
    listState.trendingInfo?.let {
        TrendingSuccessScreen(state = listState)
    }
    listState.error?.let {
        TrendingErrorScreen(retryOnClick = retryOnClick)
    }
}

@Composable
fun ShimmerLoading(isLoading: Boolean) {
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(20) {
            ShimmerListItem(
                isLoading = isLoading,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            )
        }
    }
}
