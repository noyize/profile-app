package com.noyize.profileapp.data.source.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GeoDto(
    @Json(name = "lat")
    val lat: String?,
    @Json(name = "lng")
    val lng: String?
)