package com.noyize.profileapp.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.noyize.profileapp.data.source.local.dao.ProfileDao
import com.noyize.profileapp.data.source.local.entity.AddressEntity
import com.noyize.profileapp.data.source.local.entity.CompanyEntity
import com.noyize.profileapp.data.source.local.entity.ProfileEntity

@Database(
    entities = [ProfileEntity::class, AddressEntity::class, CompanyEntity::class],
    version = 1,
    exportSchema = false
)
abstract class ProfileAppDatabase : RoomDatabase() {
    abstract val profileDao: ProfileDao
}