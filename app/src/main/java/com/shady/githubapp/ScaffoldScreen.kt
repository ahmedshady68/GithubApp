package com.shady.githubapp

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

@Composable
fun TrendingScreen(state: TrendingViewState) {
    Scaffold(
        topBar = {
            AppBarTrending()
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            TrendingListView(state)
        }
    }
}

@Composable
fun TrendingListView(state: TrendingViewState) {
    Surface(
        color = MaterialTheme.colors.background
    ) {
        if (state.isLoading) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                CircularProgressIndicator() // TODO: temp progress till shimmer
            }
        }
        state.trendingInfo?.let {
            LazyColumn() {
                items(state.trendingInfo.items) { item ->
                    TrendingCard(state = item)
                }
            }
        }
        state.error?.let { error ->
            Box(  // TODO: temp progress till Lottie
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = error,
                    color = Color.Red,
                    textAlign = TextAlign.Center,
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }
    }
}

@Composable
fun AppBarTrending() {
    TopAppBar(
        title = {
            Text(
                stringResource(R.string.trending_screen_title),
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth(), fontWeight = FontWeight.Bold
            )
        },
        actions = {
            IconButton(onClick = { }) {
                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = stringResource(R.string.menu_icon_content_des)
                )
            }
        },
        backgroundColor = Color.White,
        contentColor = Color.Black,
        elevation = 1.dp
    )
}