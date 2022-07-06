package com.noyize.profileapp.presentation.profiles.components

import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.noyize.profileapp.domain.model.Profile

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileItem(
    modifier: Modifier = Modifier,
    profile: Profile,
    onProfileClick : (Int) -> Unit
) {
    Card(
        modifier = modifier,
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
            contentColor = MaterialTheme.colorScheme.onSurfaceVariant
        ),
        onClick = {
            onProfileClick(profile.id)
        }
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