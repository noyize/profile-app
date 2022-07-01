package com.noyize.profileapp.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "company_table")
data class CompanyEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val profileId : Int,
    val bs: String,
    val catchPhrase: String,
    val name: String
)