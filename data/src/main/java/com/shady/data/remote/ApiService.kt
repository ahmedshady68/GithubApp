package com.shady.data.remote

import com.shady.data.models.TrendingRawResponse
import retrofit2.http.GET

interface ApiService {
    companion object {
        const val BASE_URL = "https://api.github.com/search/"
    }
    @GET("repositories?q=language=+sort:stars")
    suspend fun getTrending(): TrendingRawResponse
}