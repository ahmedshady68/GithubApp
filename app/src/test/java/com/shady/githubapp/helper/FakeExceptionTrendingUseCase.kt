package com.shady.githubapp.helper

import com.shady.domain.entity.TrendingResponse
import com.shady.domain.usecase.GetTrendingParent
import kotlinx.coroutines.flow.MutableSharedFlow

class FakeExceptionTrendingUseCase : GetTrendingParent {
    private var fakeFlow = MutableSharedFlow<TrendingResponse>()
    private var localException: Exception = Exception("error")
    suspend fun emit(value: TrendingResponse?) = value?.let { fakeFlow.emit(it) }

    override suspend operator fun invoke() = throw localException
    fun setException(exception: Exception) {
        localException = exception
    }
}