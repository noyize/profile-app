package com.noyize.profileapp.data.source.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CompanyDto(
    @Json(name = "bs")
    val bs: String?,
    @Json(name = "catchPhrase")
    val catchPhrase: String?,
    @Json(name = "name")
    val name: String?
)