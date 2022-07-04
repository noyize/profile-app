package com.noyize.profileapp.domain.usecase

import com.noyize.profileapp.domain.model.ProfileDetail
import com.noyize.profileapp.domain.repository.ProfileRepository
import kotlinx.coroutines.flow.Flow

class GetProfileDetails(private val profileRepository: ProfileRepository) {

    operator fun invoke(profileId: Int): Flow<ProfileDetail?> {
        return profileRepository.getProfileDetail(profileId)
    }

}