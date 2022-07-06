package com.noyize.profileapp.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.HomeWork
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.noyize.profileapp.R
import com.noyize.profileapp.domain.model.Address
import com.noyize.profileapp.presentation.profiles.components.TextWithIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddressItem(modifier: Modifier = Modifier, address: Address) {
    Card(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.address),
            style = MaterialTheme.typography.headlineSmall)
            TextWithIcon(
                text = "${address.city}, ${address.street}, ${address.suite}, ${address.zipcode}",
                imageVector = Icons.Outlined.HomeWork
            )
            Button(
                modifier = Modifier.padding(bottom = 16.dp),
                onClick = { /*TODO*/ },
                shape = RoundedCornerShape(32.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.tertiary,
                    contentColor = MaterialTheme.colorScheme.onTertiary
                )
            ) {
                Text(text = stringResource(id = R.string.view_on_map),)
            }
        }
    }
}