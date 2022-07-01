package com.noyize.profileapp.data.source.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "address_table")
data class AddressEntity(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val profileId : Int,
    val city: String,
    val street: String,
    val suite: String,
    val zipcode: String,
    val lat: String,
    val lng: String
)
