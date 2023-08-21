package com.shady.githubapp.di

import com.shady.domain.repo.TrendingRepo
import com.shady.domain.usecase.GetTrending
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {
    @Provides
    fun provideTrendingUseCase(trendingRepo: TrendingRepo): GetTrending {
        return GetTrending(trendingRepo)
    }
}