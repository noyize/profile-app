package com.noyize.profileapp.domain.model

data class Address(
    val id : Int,
    val profileId : Int,
    val city: String,
    val street: String,
    val suite: String,
    val zipcode: String,
    val lat: String,
    val lng: String
)