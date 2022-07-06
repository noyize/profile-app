package com.noyize.profileapp.data.mapper

import com.noyize.profileapp.data.source.local.entity.CompanyEntity
import com.noyize.profileapp.data.source.remote.dto.CompanyDto
import com.noyize.profileapp.domain.model.Company

fun CompanyDto?.toEntity(profileId: Int): CompanyEntity {
    return if (this == null) CompanyEntity(
        profileId = profileId,
        bs = "",
        catchPhrase = "",
        name = ""
    ) else
        CompanyEntity(
            profileId = profileId,
            bs = bs ?: "Not provided",
            catchPhrase = catchPhrase ?: "Not Provided",
            name = name ?: "Not provided"
        )
}

fun CompanyEntity.toCompany(): Company {
    return Company(
        id = id,
        profileId = profileId,
        bs = bs,
        catchPhrase = catchPhrase,
        name = name
    )
}