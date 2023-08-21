package com.shady.githubapp.di

import com.shady.data.remote.ApiService
import com.shady.data.repo.TrendingRepoImpl
import com.shady.domain.repo.TrendingRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
@Module
@InstallIn(SingletonComponent::class)
object RepoModule {
    @Provides
    fun provideTrendingRepo(apiService: ApiService): TrendingRepo {
        return TrendingRepoImpl(apiService)
    }
}