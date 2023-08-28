package com.shady.data.mappers

import com.shady.data.models.Item
import com.shady.domain.entity.TrendingDomainModel
import com.shady.domain.entity.TrendingDominItem

open class TrendingMappper {

    fun apply(raw: List<Item>?): TrendingDomainModel {
        val toastItemDomainEntity = raw?.map {
            // checkInvalidParameters(it)
            mapToToastItemDomainEntity(it)
        }
        return TrendingDomainModel(toastItemDomainEntity)
    }

    /*private fun checkInvalidParameters(raw: Item) {
        val invalidParams: MutableList<String> = mutableListOf()
        if (raw.fullName == null) invalidParams.add("fullName")
        if (raw.description == null) invalidParams.add("description")
        if (raw.language == null) invalidParams.add("language")
        if (raw.owner == null) invalidParams.add("owner")
        if (invalidParams.isNotEmpty()) throw EssentialParamMissingException(invalidParams)
    }*/

    private fun mapToToastItemDomainEntity(it: Item) =
        TrendingDominItem(
            fullName = it.fullName ?: "",
            description = it.description ?: "",
            language = it.language ?: "",
            stargazersCount = it.stargazersCount ?: "",
            imageProfile = it.owner?.imageProfile ?: "",
            userName = it.owner?.userName ?: ""
        )
}