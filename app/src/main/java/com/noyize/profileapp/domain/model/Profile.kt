package com.noyize.profileapp.domain.model

data class Profile(
    val id: Int,
    val name: String,
    val phone: String,
    val profileImage: String,
    val username: String,
    val website: String
)
