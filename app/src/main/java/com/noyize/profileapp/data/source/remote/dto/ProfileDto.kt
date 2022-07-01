package com.noyize.profileapp.data.source.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ProfileDto(
    @Json(name = "address")
    val addressDto: AddressDto?,
    @Json(name = "company")
    val companyDto: CompanyDto?,
    @Json(name = "email")
    val email: String?,
    @Json(name = "id")
    val id: Int?,
    @Json(name = "name")
    val name: String?,
    @Json(name = "phone")
    val phone: Any?,
    @Json(name = "profile_image")
    val profileImage: String?,
    @Json(name = "username")
    val username: String?,
    @Json(name = "website")
    val website: String?
)