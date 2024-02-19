package com.dimchel.fa.feature.leagues.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.dimchel.fa.core.theme.FaTheme
import com.dimchel.fa.feature.leagues.domain.models.LeagueModel

@Composable
internal fun LeaguesScreen(
    viewModel: LeaguesViewModel,
    onLeagueClicked: (leagueId: Int) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    FaTheme {
        Surface {
            when (val state = uiState) {
                is LeaguesUiState.Loading -> LoadingState()
                is LeaguesUiState.Error -> ErrorState()
                is LeaguesUiState.Success -> SuccessState(state.leaguesList, onLeagueClicked)
            }
        }
    }
}

@Composable
internal fun LoadingState() {
    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp)
        )
    }
}

@Composable
internal fun ErrorState() {
    // TODO: Implement this
}

@Composable
internal fun SuccessState(
    leagues: List<LeagueModel>,
    onLeagueClicked: (leagueId: Int) -> Unit,
) {
    LazyColumn {
        items(leagues) { league ->
            LeagueCard(league, onLeagueClicked)
        }
    }
}

@Composable
internal fun LeagueCard(
    league: LeagueModel,
    onLeagueClicked: (leagueId: Int) -> Unit,
) {
    Row(
        modifier = Modifier.clickable { onLeagueClicked(league.id) },
        verticalAlignment = Alignment.CenterVertically,
    ) {
        AsyncImage(
            modifier = Modifier
                .padding(16.dp)
                .size(32.dp),
            model = league.emblemUrl,
            contentDescription = null,
        )
        Spacer(modifier = Modifier.size(8.dp))
        Text(
            modifier = Modifier
                .fillMaxSize(),
            text = league.name,
        )
        HorizontalDivider()
    }
}