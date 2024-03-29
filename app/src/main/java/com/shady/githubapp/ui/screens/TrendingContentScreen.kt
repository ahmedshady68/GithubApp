package com.shady.githubapp.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.shady.githubapp.ui.entities.TrendingViewState
import com.shady.githubapp.ui.composable.ShimmerListItem

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
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.secondary)
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
