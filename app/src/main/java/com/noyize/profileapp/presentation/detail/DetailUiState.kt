package com.noyize.profileapp.presentation.detail

import com.noyize.profileapp.domain.model.ProfileDetail

data class DetailUiState(
    val isLoading : Boolean = true,
    val profileDetail: ProfileDetail? = null,
    val error : String? = null
)
