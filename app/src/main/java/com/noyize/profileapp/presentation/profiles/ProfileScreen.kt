@file:OptIn(ExperimentalFoundationApi::class)

package com.noyize.profileapp.presentation.profiles

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AlternateEmail
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Web
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.noyize.profileapp.R
import com.noyize.profileapp.domain.model.Profile
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@Composable
@Destination()
@RootNavGraph(start = true)
fun ProfileScreen(
    viewModel: ProfileViewModel = hiltViewModel()
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
                modifier=Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(state.profiles) { profile ->
                    ProfileItem(
                        profile = profile, modifier = Modifier
                            .fillMaxWidth()
                            .animateItemPlacement()
                    )
                }
            }
        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileItem(
    modifier: Modifier = Modifier,
    profile: Profile
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        )
    ) {
        Row(
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()
        ) {
            AsyncImage(
                model = profile.profileImage, contentDescription = null,
                modifier = Modifier
                    .padding(top = 8.dp)
                    .size(48.dp)
                    .align(Alignment.Top)
                    .clip(RoundedCornerShape(100))

            )
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier
                    .padding(horizontal = 32.dp)
                    .align(Alignment.Top)
            ) {
                Text(text = profile.name, style = MaterialTheme.typography.bodyLarge)
                TextWithIcon(text = profile.username, imageVector = Icons.Outlined.AlternateEmail)
                TextWithIcon(text = profile.phone, imageVector = Icons.Outlined.Phone)
                TextWithIcon(text = profile.website, imageVector = Icons.Outlined.Web)
            }
        }
    }

}


@Composable
fun TextWithIcon(text: String, imageVector: ImageVector, modifier: Modifier = Modifier) {
    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically) {
        Icon(imageVector = imageVector, contentDescription = null)
        Spacer(modifier = Modifier.width(8.dp))
        Text(text = text, style = MaterialTheme.typography.labelLarge)
    }
}