package com.shady.githubapp.helper

import com.shady.domain.usecase.GetTrendingParent
import kotlinx.coroutines.flow.MutableSharedFlow

class FakeThrowableTrendingUseCase : GetTrendingParent {
    private var fakeFlow = MutableSharedFlow<Throwable>()
    private var localThrowable: Throwable = Throwable("error")

    suspend fun emit(value: Throwable?) = value?.let { fakeFlow.emit(it) }
    override suspend operator fun invoke() = throw localThrowable
    fun setThrowable(throwable: Throwable) {
        localThrowable = throwable
    }
}