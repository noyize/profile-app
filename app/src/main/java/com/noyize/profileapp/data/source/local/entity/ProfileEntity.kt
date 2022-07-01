package com.noyize.profileapp.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "profile_table")
data class ProfileEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val phone: String,
    val profileImage: String,
    val username: String,
    val website: String
)
