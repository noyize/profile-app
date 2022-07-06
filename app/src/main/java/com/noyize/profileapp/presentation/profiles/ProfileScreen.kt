@file:OptIn(ExperimentalFoundationApi::class)

package com.noyize.profileapp.presentation.profiles

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.noyize.profileapp.R
import com.noyize.profileapp.destination.destinations.DetailScreenDestination
import com.noyize.profileapp.presentation.profiles.components.ProfileItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination()
@RootNavGraph(start = true)
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val state = viewModel.state

    Column(modifier = Modifier.fillMaxSize()) {
        SmallTopAppBar(
            modifier = Modifier.systemBarsPadding(),
            title = { Text(text = stringResource(id = R.string.app_name)) },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
        if (state.isLoading) {
            LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.profiles) { profile ->
                    ProfileItem(
                        profile = profile, modifier = Modifier
                            .fillMaxWidth()
                            .animateItemPlacement(),
                        onProfileClick = { id ->
                            navigator.navigate(DetailScreenDestination(id))
                        }
                    )
                }
            }
        }
    }

}




