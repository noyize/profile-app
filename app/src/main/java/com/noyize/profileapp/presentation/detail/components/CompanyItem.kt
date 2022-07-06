package com.noyize.profileapp.presentation.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FormatQuote
import androidx.compose.material.icons.outlined.Work
import androidx.compose.material.icons.outlined.WorkOutline
import androidx.compose.material.icons.outlined.Workspaces
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.noyize.profileapp.R
import com.noyize.profileapp.domain.model.Company
import com.noyize.profileapp.presentation.profiles.components.TextWithIcon

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CompanyItem(modifier: Modifier = Modifier, company: Company) {
    Card(modifier = modifier) {
        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
                .padding(16.dp)
        ) {
            Text(text = stringResource(id = R.string.company),
                style = MaterialTheme.typography.headlineSmall)
            TextWithIcon(text = company.name, imageVector = Icons.Outlined.WorkOutline)
            TextWithIcon(text = company.catchPhrase, imageVector = Icons.Outlined.FormatQuote)
            TextWithIcon(text = company.bs, imageVector = Icons.Outlined.Workspaces)
        }
    }
}