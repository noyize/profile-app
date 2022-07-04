package com.noyize.profileapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noyize.profileapp.data.source.local.entity.AddressEntity
import com.noyize.profileapp.data.source.local.entity.CompanyEntity
import com.noyize.profileapp.data.source.local.entity.ProfileDetailEntity
import com.noyize.profileapp.data.source.local.entity.ProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProfiles(profiles: List<ProfileEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllAddress(addressEntity: List<AddressEntity>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllCompany(companyEntity: List<CompanyEntity>)

    @Query("DELETE FROM company_table")
    suspend fun clearCompanies()

    @Query("DELETE FROM address_table")
    suspend fun clearAddresses()

    @Query("SELECT * FROM profile_table WHERE id=:profileId")
    fun getProfileDetails(profileId: Int): Flow<ProfileDetailEntity>

    @Query("SELECT * FROM profile_table")
    fun getProfiles() : Flow<List<ProfileEntity>>

}