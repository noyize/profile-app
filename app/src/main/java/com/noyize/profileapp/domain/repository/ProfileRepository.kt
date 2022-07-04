package com.noyize.profileapp.domain.repository

import com.noyize.profileapp.app.util.Resource
import com.noyize.profileapp.domain.model.Profile
import com.noyize.profileapp.domain.model.ProfileDetail
import kotlinx.coroutines.flow.Flow

interface ProfileRepository {

    fun getProfiles(): Flow<Resource<List<Profile>>>

    fun getProfileDetail(profileId : Int): Flow<ProfileDetail?>

}