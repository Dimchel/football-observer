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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.decode.SvgDecoder
import coil.request.ImageRequest
import com.dimchel.fa.feature.competitions.domain.models.CompetitionModel

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
    Box(contentAlignment = Alignment.Center) {
        Text(text = "Some error happened")
    }
}

@Composable
internal fun SuccessState(
    competitions: List<CompetitionModel>,
    onCompetitionClicked: (competition: CompetitionModel) -> Unit,
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
    onCompetitionClicked: (competition: CompetitionModel) -> Unit,
) {
    Column {
        Row(
            modifier = Modifier.clickable { onCompetitionClicked(competition) },
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
                        color = MaterialTheme.colorScheme.tertiaryContainer,
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
private fun CompetitionItemPreview() {
    CompetitionItem(
        competition = CompetitionModel(1, "Premiew league", "", "", ""),
        onCompetitionClicked = {},
    )
}

@Preview
@Composable
private fun CompetitionLoadingPreview() {
    LoadingState()
}

@Preview
@Composable
private fun CompetitionErrorPreview() {
    ErrorState()
}