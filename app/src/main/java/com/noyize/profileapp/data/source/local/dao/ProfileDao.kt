package com.noyize.profileapp.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.noyize.profileapp.data.source.local.entity.ProfileDetailEntity
import com.noyize.profileapp.data.source.local.entity.ProfileEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ProfileDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllProfiles(profiles: List<ProfileEntity>)

    @Query("SELECT * FROM profile_table WHERE id=:profileId")
    fun getProfileDetails(profileId: Int): Flow<ProfileDetailEntity>

}