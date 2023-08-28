package com.shady.githubapp.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.shady.githubapp.entities.TrendingViewState
import com.shady.githubapp.ui.composable.AppBarTrending
import com.shady.githubapp.ui.theme.GithubAppTheme

@Composable
fun TrendingGithubApp(listState: TrendingViewState, retryOnClick: () -> Unit) {
    GithubAppTheme {
        Scaffold(
            topBar = {
                AppBarTrending()
            }
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                TrendingList(listState = listState, retryOnClick = retryOnClick)
            }
        }
    }
}