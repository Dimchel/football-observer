package com.dimchel.fa.league.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.dimchel.fa.core.common.architecture.Screen
import com.dimchel.fa.core.common.architecture.application
import com.dimchel.fa.core.common.architecture.daggerViewModel
import com.dimchel.fa.core.theme.debugPlaceholder
import com.dimchel.fa.core.ui.R
import com.dimchel.fa.league.di.LeagueDependencyProvider
import com.dimchel.fa.league.domain.models.CompetitorModel
import com.dimchel.fa.league.domain.models.TeamModel

internal class LeagueScreen : Screen {

    @Composable
    override fun Content() {
        val application = application()
        val viewModel: LeagueViewModel = daggerViewModel {
            LeagueDependencyProvider.provide(application).getViewModel()
        }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        when (val state = uiState) {
            is LeagueUiState.Loading -> LoadingState()
            is LeagueUiState.Error -> ErrorState()
            is LeagueUiState.Success -> SuccessState(state.standings)
        }
    }
}

@Composable
private fun LoadingState() {
    Box(contentAlignment = Alignment.Center) {
        CircularProgressIndicator(
            modifier = Modifier.width(64.dp)
        )
    }
}

@Composable
private fun ErrorState() {
    Text(text = "Some error happened")
}

@Composable
private fun SuccessState(
    standings: List<CompetitorModel>,
) {
    Column {
        Header()
        LazyColumn {
            itemsIndexed(standings) { index, league ->
                LeagueItem(index, league)
            }
        }
    }
}

private const val clubColumnWeight = 8f
private const val otherColumnWeight = 1f

@Composable
private fun Header() {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 4.dp,
                    bottom = 4.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "Club",
                textAlign = TextAlign.Start,
                modifier = Modifier.weight(clubColumnWeight),
                fontSize = 14.sp,
            )
            Text(text = "MP",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(text = "W",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(text = "D",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(text = "L",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(text = "GF",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(text = "GA",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(text = "GD",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(text = "Pts",
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.secondaryContainer)
    }
}

@Composable
private fun LeagueItem(position: Int, competitor: CompetitorModel) {
    Column {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    start = 16.dp,
                    end = 16.dp,
                    top = 4.dp,
                    bottom = 4.dp,
                ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(modifier = Modifier.weight(clubColumnWeight)) {
                Text(
                    text = (position + 1).toString(),
                    modifier = Modifier.weight(1f),
                )
                Spacer(modifier = Modifier.size(4.dp))
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(competitor.team.crestUrl)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    contentDescription = "Team crest",
                    placeholder = debugPlaceholder(debugPreview = R.drawable.ic_debug_placeholder),
                    modifier = Modifier
                        .size(24.dp)
                        .weight(1f),
                )
                Spacer(modifier = Modifier.size(8.dp))
                Text(
                    text = competitor.team.shortName,
                    modifier = Modifier.weight(6f),
                )
            }
            Text(
                text = competitor.playedGames.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(
                text = competitor.won.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(
                text = competitor.draw.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(
                text = competitor.lost.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(
                text = competitor.goalsFor.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(
                text = competitor.goalsAgainst.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(
                text = competitor.goalDifference.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
            )
            Text(
                text = competitor.points.toString(),
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(otherColumnWeight),
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.secondaryContainer)
    }
}

@Preview
@Composable
private fun HeaderPreview() {
    Header()
}

@Preview
@Composable
private fun LeagueItemPreview() {
    val competitor = CompetitorModel(
        position = 1,
        team = TeamModel(
            1,
            "Manchester City",
            "Man City",
            "",
        ),
        playedGames = 23,
        won = 4,
        draw = 5,
        lost = 6,
        points = 56,
        goalsFor = 33,
        goalsAgainst = 66,
        goalDifference = 12,
    )
    LeagueItem(0, competitor)
}