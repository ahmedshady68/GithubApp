package com.shady.githubapp.composable

import androidx.compose.runtime.Composable
import com.shady.domain.entity.Item
import com.shady.domain.entity.Owner
import com.shady.domain.entity.TrendingResponse
import com.shady.githubapp.TrendingViewState
import com.shady.githubapp.screens.TrendingGithubApp
import com.shady.githubapp.ui.theme.GithubAppTheme


@Composable
fun GithubAppPreview() {
    GithubAppTheme {
        TrendingGithubApp(
            TrendingViewState(
                TrendingResponse(
                    false, listOf(
                        Item(
                            "Android Repo",
                            "Senior Android Developer",
                            "Kotlin",
                            "500",
                            Owner("https://avatars.githubusercontent.com/u/4314092?v=4", "Alex")
                        )
                    ), 0
                )
            )
        ) {
            // retry onClick
        }
    }
}