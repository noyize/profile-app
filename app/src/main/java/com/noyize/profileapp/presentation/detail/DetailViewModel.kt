package com.noyize.profileapp.presentation.detail

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noyize.profileapp.domain.usecase.GetProfileDetails
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getProfileDetails: GetProfileDetails,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var state by mutableStateOf(DetailUiState())
        private set

    init {
        savedStateHandle.get<Int>(KEY_PROFILE_ID)?.let { id ->
            getProfileDetailById(id)
        } ?: run {
            state = state.copy(isLoading = false, error = ERROR_INVALID_PROFILE_ID)
        }
    }

    private fun getProfileDetailById(profileId: Int) {
        viewModelScope.launch {
            getProfileDetails(profileId).collect { profileDetail ->
                state = state.copy(isLoading = false, profileDetail = profileDetail)
            }
        }
    }

    companion object {
        const val KEY_PROFILE_ID = "profileId"
        const val ERROR_INVALID_PROFILE_ID = "Invalid profile id"
    }
}