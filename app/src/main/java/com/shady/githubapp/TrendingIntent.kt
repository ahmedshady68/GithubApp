package com.shady.githubapp

sealed class TrendingIntent {
    object GetTrending : TrendingIntent()
}
