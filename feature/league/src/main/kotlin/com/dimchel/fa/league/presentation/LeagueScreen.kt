package com.dimchel.fa.league.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.dimchel.fa.core.theme.FaTheme
import com.dimchel.fa.league.domain.models.CompetitorModel

@Composable
internal fun LeagueScreen(viewModel: LeagueViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    FaTheme(dynamicColor = true) {
        Surface {
            when (val state = uiState) {
                is LeagueUiState.Loading -> LoadingState()
                is LeagueUiState.Error -> ErrorState()
                is LeagueUiState.Success -> SuccessState(state.standings)
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
    Text(text = "Some error happened")
}

@Composable
internal fun SuccessState(
    standings: List<CompetitorModel>,
) {
    Column {
        Header()
        LazyColumn {
            items(standings) { league ->
                LeagueCard(league)
            }
        }
    }
}

@Composable
internal fun Header() {
    Row {
        Text(text = "Club")
    }
}

@Composable
internal fun LeagueCard(competitor: CompetitorModel) {
    Row {

    }
}