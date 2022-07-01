package com.noyize.profileapp.data.source.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ProfileDetailEntity(
    @Embedded
    val profileEntity : ProfileEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "profileId"
    )
    val addressEntity: AddressEntity,
    @Relation(
        parentColumn = "id",
        entityColumn = "profileId"
    )
    val companyEntity: CompanyEntity
)
