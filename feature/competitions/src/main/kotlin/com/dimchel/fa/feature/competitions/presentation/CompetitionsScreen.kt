package com.dimchel.fa.feature.competitions.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.dimchel.fa.core.common.architecture.Screen
import com.dimchel.fa.core.common.architecture.application
import com.dimchel.fa.core.common.architecture.daggerViewModel
import com.dimchel.fa.feature.competitions.di.CompetitionsDependencyProvider
import com.dimchel.fa.feature.competitions.domain.models.CompetitionModel

internal class CompetitionsScreen : Screen {

    @Composable
    override fun Content() {
        val application = application()
        val viewModel: CompetitionsViewModel = daggerViewModel {
            CompetitionsDependencyProvider.provide(application).getViewModel()
        }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        when (val state = uiState) {
            is CompetitionsUiState.Loading -> LoadingState()
            is CompetitionsUiState.Error -> ErrorState()
            is CompetitionsUiState.Success -> SuccessState(
                state.competitionsList,
                onCompetitionClicked = { viewModel.onLeagueClicked(it) }
            )
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
    competitions: List<CompetitionModel>,
    onCompetitionClicked: (competitionId: Int) -> Unit,
) {
    LazyColumn {
        items(competitions) { competition ->
            CompetitionItem(competition, onCompetitionClicked)
        }
    }
}

@Composable
private fun CompetitionItem(
    competition: CompetitionModel,
    onCompetitionClicked: (competitionId: Int) -> Unit,
) {
    Column {
        Row(
            modifier = Modifier.clickable { onCompetitionClicked(competition.id) },
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Box(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        top = 4.dp,
                        bottom = 4.dp,
                    )
                    .background(
                        color = MaterialTheme.colorScheme.secondaryContainer,
                        shape = RoundedCornerShape(12.dp)
                    ),
                contentAlignment = Alignment.Center,
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(competition.emblemUrl)
                        .decoderFactory(SvgDecoder.Factory())
                        .build(),
                    modifier = Modifier
                        .padding(8.dp)
                        .size(48.dp),
                    contentDescription = null,
                )
            }
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                modifier = Modifier.fillMaxSize(),
                text = competition.name,
            )
        }
        HorizontalDivider(color = MaterialTheme.colorScheme.secondaryContainer)
    }
}

@Preview
@Composable
private fun CompetitionItem() {
    CompetitionItem(
        competition = CompetitionModel(1, "Premiew league", "", ""),
        onCompetitionClicked = {},
    )
}