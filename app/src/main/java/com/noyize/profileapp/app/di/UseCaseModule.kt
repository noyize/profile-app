package com.noyize.profileapp.app.di

import com.noyize.profileapp.domain.repository.ProfileRepository
import com.noyize.profileapp.domain.usecase.GetProfileDetails
import com.noyize.profileapp.domain.usecase.GetSortedProfilesByName
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
class UseCaseModule {

    @Provides
    fun provideGetSortedProfilesByNameUseCase(profileRepository: ProfileRepository) = GetSortedProfilesByName(profileRepository)

    @Provides
    fun provideProfileDetailUseCase(profileRepository: ProfileRepository) = GetProfileDetails(profileRepository)

}