package com.shady.githubapp.helper

import com.shady.data.models.TrendingRawResponse
import com.shady.domain.usecase.GetTrendingParent
import kotlinx.coroutines.flow.MutableSharedFlow

class FakeExceptionTrendingUseCase : GetTrendingParent {
    private var fakeFlow = MutableSharedFlow<TrendingRawResponse>()
    private var localException: Exception = Exception("error")
    suspend fun emit(value: TrendingRawResponse?) = value?.let { fakeFlow.emit(it) }

    override suspend operator fun invoke() = throw localException
    fun setException(exception: Exception) {
        localException = exception
    }
}