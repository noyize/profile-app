package com.noyize.profileapp.presentation.profiles

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.noyize.profileapp.app.util.Resource
import com.noyize.profileapp.domain.usecase.GetSortedProfilesByName
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val getSortedProfilesByName: GetSortedProfilesByName
) : ViewModel() {

    var state by mutableStateOf(ProfileUiState())
        private set

    init {
        getProfiles()
    }

    private fun getProfiles() {
        viewModelScope.launch {
            getSortedProfilesByName().collect { result ->
                state = when (result) {
                    is Resource.Loading -> state.copy(isLoading = true)
                    is Resource.Success -> state.copy(isLoading = false, profiles = result.value)
                    is Resource.Error -> state.copy(isLoading = false, error = result.error)
                }
            }
        }
    }
}