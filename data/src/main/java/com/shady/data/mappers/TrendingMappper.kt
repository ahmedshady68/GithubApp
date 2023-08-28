package com.shady.data.mappers

import com.shady.data.models.Item
import com.shady.domain.entity.TrendingDomainModel
import com.shady.domain.entity.TrendingDominItem

open class TrendingMappper {

    fun apply(raw: List<Item>?): TrendingDomainModel {
        val toastItemDomainEntity = raw?.map {
            mapToToastItemDomainEntity(it)
        }
        return TrendingDomainModel(toastItemDomainEntity)
    }

    private fun mapToToastItemDomainEntity(it: Item) =
        TrendingDominItem(
            fullName = it.fullName ?: "N/A",
            description = it.description ?: "N/A",
            language = it.language ?: "N/A",
            stargazersCount = it.stargazersCount ?: "N/A",
            imageProfile = it.owner?.imageProfile ?: "N/A",
            userName = it.owner?.userName ?: "N/A"
        )
}