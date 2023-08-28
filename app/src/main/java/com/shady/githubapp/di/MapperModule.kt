package com.shady.githubapp.di

import com.shady.data.mappers.TrendingMappper
import com.shady.githubapp.ui.mapper.TrendingViewEntityMapper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object MapperModule {
    @Provides
    fun provideTrendingMapper(): TrendingMappper {
        return TrendingMappper()
    }

    @Provides
    fun provideTrendingViewMapper(): TrendingViewEntityMapper {
        return TrendingViewEntityMapper()
    }
}