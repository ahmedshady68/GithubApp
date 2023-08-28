package com.shady.githubapp.ui.mapper

import com.shady.domain.entity.TrendingDomainModel
import com.shady.githubapp.ui.entities.TrendingViewItem

class TrendingViewEntityMapper {

    fun apply(domainEntity: TrendingDomainModel?): List<TrendingViewItem>? {
        return domainEntity?.items?.map {
            TrendingViewItem(
                title = it.userName,
                subTitle = it.fullName,
                description = it.description,
                stars = it.stargazersCount,
                programmingLanguage = it.language,
                imageProfileUrl = it.imageProfile
            )
        }
    }
}