package com.noyize.profileapp.presentation.profiles

import com.noyize.profileapp.domain.model.Profile

data class ProfileUiState(
    val isLoading : Boolean = false,
    val profiles : List<Profile> = emptyList(),
    val error : String? = null
)
