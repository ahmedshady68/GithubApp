package com.shady.githubapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.shady.githubapp.ui.theme.GithubAppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: TrendingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            viewModel.intentChannel.send(TrendingIntent.GetTrending)
        }
        setContent {
            GithubAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val state = viewModel.trendingViewState
                    if (state.isLoading) {
                        // view for progress
                        Box(
                            contentAlignment = Alignment.Center,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            CircularProgressIndicator() // TODO: temp progress till shimmer
                        }
                    }
                    state.trendingInfo?.let {
                        Greeting(name = "Android") // TODO: temp progress till Card
                        LazyColumn(modifier = Modifier.fillMaxSize()) {
                            items(state.trendingInfo.items) { item ->
                                Greeting(name = item.full_name) // TODO: temp progress till Card
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
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello ${name}!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    GithubAppTheme {
        Greeting("Android")
    }
}