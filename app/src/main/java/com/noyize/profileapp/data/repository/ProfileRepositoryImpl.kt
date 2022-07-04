package com.noyize.profileapp.data.repository

import android.content.SharedPreferences
import com.noyize.profileapp.app.util.Resource
import com.noyize.profileapp.app.util.networkBoundResource
import com.noyize.profileapp.data.mapper.toEntity
import com.noyize.profileapp.data.mapper.toProfile
import com.noyize.profileapp.data.mapper.toProfileDetail
import com.noyize.profileapp.data.source.local.dao.ProfileDao
import com.noyize.profileapp.data.source.remote.ProfileService
import com.noyize.profileapp.data.source.remote.dto.ProfileDto
import com.noyize.profileapp.domain.model.Profile
import com.noyize.profileapp.domain.model.ProfileDetail
import com.noyize.profileapp.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class ProfileRepositoryImpl @Inject constructor(
    private val profileDao: ProfileDao,
    private val profileService: ProfileService,
    private val sharedPreferences: SharedPreferences
) : ProfileRepository {

    override fun getProfiles(): Flow<Resource<List<Profile>>> {
        return networkBoundResource(
            query = { getFromLocalDatabase() },
            fetch = { profileService.getProfiles() },
            saveFetchResult = { result -> saveToLocalDatabase(result) },
            shouldFetch = { isStaleCache() })
    }

    override fun getProfileDetail(profileId: Int): Flow<ProfileDetail?> {
        return profileDao.getProfileDetails(profileId).map { it.toProfileDetail() }
    }

    private fun getFromLocalDatabase(): Flow<List<Profile>> {
        return profileDao.getProfiles()
            .map { profileEntities -> profileEntities.map { it.toProfile() } }
    }

    private suspend fun saveToLocalDatabase(profiles: List<ProfileDto>) {
        profileDao.clearCompanies()
        profileDao.clearAddresses()
        val profileEntities = profiles.map { it.toEntity() }
        val addressEntities  = profiles.map { profile -> profile.addressDto.toEntity(profile.id!!)  }
        val companyEntities  = profiles.map { profile -> profile.companyDto.toEntity(profile.id!!)  }
        profileDao.insertAllProfiles(profileEntities)
        profileDao.insertAllAddress(addressEntities)
        profileDao.insertAllCompany(companyEntities)
        sharedPreferences.edit().putLong(CACHE_KEY, System.currentTimeMillis()).apply()
    }

    private fun isStaleCache(): Boolean {
        val lastSyncTimeInMillis = sharedPreferences.getLong(CACHE_KEY, 0)
        val timeAfterLastSync = System.currentTimeMillis() - lastSyncTimeInMillis
        val staleTime = TimeUnit.MINUTES.toMillis(1)
        return (lastSyncTimeInMillis == 0L || timeAfterLastSync > staleTime)
    }

    companion object {
        const val CACHE_KEY = "cache_key"
    }
}