package com.shady.githubapp.ui.composable

import androidx.compose.runtime.Composable
import com.shady.githubapp.ui.entities.TrendingViewState
import com.shady.githubapp.ui.entities.TrendingViewItem
import com.shady.githubapp.ui.screens.TrendingGithubApp
import com.shady.githubapp.ui.theme.GithubAppTheme

@Composable
fun GithubAppPreview() {
    GithubAppTheme {
        TrendingGithubApp(
            TrendingViewState(
                listOf(
                    TrendingViewItem(
                        title = "Android Repo",
                        subTitle = "Senior Android Developer",
                        programmingLanguage = "Kotlin",
                        stars = "500",
                        imageProfileUrl = "https://avatars.githubusercontent.com/u/4314092?v=4",
                        description = "Alex"
                    )
                )

            )
        ) {
            // retry onClick
        }
    }
}
