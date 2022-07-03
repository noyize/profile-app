package com.noyize.profileapp.domain.usecase

import com.noyize.profileapp.app.util.Resource
import com.noyize.profileapp.domain.model.Profile
import com.noyize.profileapp.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetSortedProfilesByName(private val profileRepository: ProfileRepository) {
    operator fun invoke(): Flow<Resource<List<Profile>>> {
        return profileRepository.getProfiles().map {
            if (it is Resource.Success)
                Resource.Success(it.value.sortedBy { profile -> profile.name })
            else it
        }
    }
}