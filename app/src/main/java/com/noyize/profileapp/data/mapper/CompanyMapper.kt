package com.noyize.profileapp.data.mapper

import com.noyize.profileapp.data.source.local.entity.CompanyEntity
import com.noyize.profileapp.data.source.remote.dto.CompanyDto
import com.noyize.profileapp.domain.model.Company

fun CompanyDto.toEntity(profileId: Int): CompanyEntity {
    return CompanyEntity(
        profileId = profileId,
        bs = bs ?: "",
        catchPhrase = catchPhrase ?: "",
        name = name ?: ""
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