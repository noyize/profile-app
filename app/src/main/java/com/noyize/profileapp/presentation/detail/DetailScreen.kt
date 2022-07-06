package com.noyize.profileapp.presentation.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.noyize.profileapp.R
import com.noyize.profileapp.presentation.detail.components.AddressItem
import com.noyize.profileapp.presentation.detail.components.CompanyItem
import com.noyize.profileapp.presentation.profiles.components.ProfileItem
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@Composable
@Destination
fun DetailScreen(
    profileId: Int,
    viewModel: DetailViewModel = hiltViewModel(),
    navigator: DestinationsNavigator
) {
    val state = viewModel.state
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        SmallTopAppBar(
            title = {
                Text(
                    text = stringResource(id = R.string.detail)
                )
            },
            navigationIcon = {
                IconButton(onClick = { navigator.navigateUp() }) {
                    Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = null)
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary,
                titleContentColor = MaterialTheme.colorScheme.onPrimary,
                navigationIconContentColor = MaterialTheme.colorScheme.onPrimary
            )
        )
        state.profileDetail?.let {
            Column(
                modifier = Modifier
                    .verticalScroll(scrollState)
                    .padding(bottom = 64.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                ProfileItem(
                    profile = it.profile, onProfileClick = {}, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                CompanyItem(
                    company = it.company, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                AddressItem(
                    address = it.address, modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                )
            }


        }

    }
}