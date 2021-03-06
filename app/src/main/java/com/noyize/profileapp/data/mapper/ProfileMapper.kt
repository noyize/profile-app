package com.noyize.profileapp.data.mapper

import com.noyize.profileapp.data.source.local.entity.ProfileDetailEntity
import com.noyize.profileapp.data.source.local.entity.ProfileEntity
import com.noyize.profileapp.data.source.remote.dto.ProfileDto
import com.noyize.profileapp.domain.model.Profile
import com.noyize.profileapp.domain.model.ProfileDetail

fun ProfileDto.toEntity(): ProfileEntity {
    return ProfileEntity(
        id = id ?: 0,
        name = name ?: "",
        phone = phone ?: "Not provided",
        profileImage = profileImage ?: "https://www.cornwallbusinessawards.co.uk/wp-content/uploads/2017/11/dummy450x450.jpg",
        username = username ?: "Not provided",
        website = website ?: "Not provided"
    )
}

fun ProfileEntity.toProfile(): Profile {
    return Profile(
        id = id,
        name = name,
        phone = phone,
        profileImage = profileImage,
        username = username,
        website = website
    )
}

fun ProfileDetailEntity.toProfileDetail(): ProfileDetail{
    return ProfileDetail(
        profile = profileEntity.toProfile(),
        address =  addressEntity.toAddress(),
        company = companyEntity.toCompany()
    )
}