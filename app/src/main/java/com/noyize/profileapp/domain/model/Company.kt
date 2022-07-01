package com.noyize.profileapp.domain.model

data class Company(
    val id: Int ,
    val profileId : Int,
    val bs: String,
    val catchPhrase: String,
    val name: String
)