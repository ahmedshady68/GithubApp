package com.shady.data.remote

import com.shady.domain.entity.TrendingResponse
import retrofit2.http.GET

interface ApiService {
    @GET("repositories?q=language=+sort:stars")
    suspend fun getTrending(): TrendingResponse
}