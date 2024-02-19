package com.dimchel.fa.feature.competitions.ui

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
import com.dimchel.fa.feature.competitions.domain.models.CompetitionModel

@Composable
internal fun CompetitionsScreen(
    viewModel: CompetitionsViewModel,
    onCompetitionClicked: (competitionId: Int) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    FaTheme(dynamicColor = true) {
        Surface {
            when (val state = uiState) {
                is CompetitionsUiState.Loading -> LoadingState()
                is CompetitionsUiState.Error -> ErrorState()
                is CompetitionsUiState.Success -> SuccessState(state.competitionsList, onCompetitionClicked)
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
internal fun CompetitionItem(
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
                    modifier = Modifier
                        .padding(8.dp)
                        .size(48.dp),
                    model = competition.emblemUrl,
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