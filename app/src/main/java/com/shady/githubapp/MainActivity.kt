package com.shady.githubapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.shady.githubapp.composable.GithubAppPreview
import com.shady.githubapp.screens.TrendingGithubApp
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: TrendingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sendIntent()
        setContent {
            TrendingGithubApp(listState = viewModel.trendingViewState, retryOnClick = ::sendIntent)
        }
    }

    private fun sendIntent() {
        lifecycleScope.launch {
            viewModel.intentChannel.send(TrendingIntent.GetTrending)
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun GithubAppPreview() {
    GithubAppPreview()
}
