package com.noyize.profileapp.data.mapper

import com.noyize.profileapp.data.source.local.entity.AddressEntity
import com.noyize.profileapp.data.source.remote.dto.AddressDto
import com.noyize.profileapp.domain.model.Address

fun AddressDto?.toEntity(profileId: Int): AddressEntity {
    return if (this == null)  AddressEntity(
        profileId = profileId,
        city =  "",
        street =  "",
        zipcode = "",
        lat =  "",
        lng =  "",
        suite =  ""
    ) else AddressEntity(
        profileId = profileId,
        city = city ?: "",
        street = street ?: "",
        zipcode = zipcode ?: "",
        lat = geoDto?.lat ?: "",
        lng = geoDto?.lng ?: "",
        suite = suite ?: ""
    )
}

fun AddressEntity.toAddress(): Address {
    return Address(
        id = id,
        profileId = profileId,
        city = city,
        street = street,
        suite = suite,
        zipcode = zipcode,
        lat = lat,
        lng = lng
    )
}