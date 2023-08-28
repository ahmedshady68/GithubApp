package com.shady.githubapp.entities

sealed class TrendingIntent {
    object GetTrending : TrendingIntent()
}
