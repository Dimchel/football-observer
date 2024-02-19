package com.dimchel.fa.league.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.width
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

@Composable
internal fun LeaguesScreen(
    viewModel: LeagueViewModel,
    onLeagueClicked: (leagueId: Int) -> Unit,
) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    FaTheme(dynamicColor = true) {
        Surface {
            when (val state = uiState) {
                is LeaguesUiState.Loading -> LoadingState()
                is LeaguesUiState.Error -> ErrorState()
//                is LeaguesUiState.Success -> SuccessState(state.leaguesList, onLeagueClicked)
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

//@Composable
//internal fun SuccessState(
//    leagues: List<LeagueModel>,
//    onLeagueClicked: (leagueId: Int) -> Unit,
//) {
//    LazyColumn {
//        items(leagues) { league ->
//            LeagueCard(league, onLeagueClicked)
//        }
//    }
//}

//@Composable
//internal fun LeagueCard(
//    league: LeagueModel,
//    onLeagueClicked: (leagueId: Int) -> Unit,
//) {
//    Column {
//        Row(
//            modifier = Modifier.clickable { onLeagueClicked(league.id) },
//            verticalAlignment = Alignment.CenterVertically,
//        ) {
//            Box(
//                modifier = Modifier
//                    .padding(
//                        start = 16.dp,
//                        top = 4.dp,
//                        bottom = 4.dp,
//                    )
//                    .background(
//                        color = MaterialTheme.colorScheme.secondaryContainer,
//                        shape = RoundedCornerShape(12.dp)
//                    ),
//                contentAlignment = Alignment.Center,
//            ) {
//                AsyncImage(
//                    modifier = Modifier
//                        .padding(8.dp)
//                        .size(48.dp),
//                    model = league.emblemUrl,
//                    contentDescription = null,
//                )
//            }
//            Spacer(modifier = Modifier.size(16.dp))
//            Text(
//                modifier = Modifier.fillMaxSize(),
//                text = league.name,
//            )
//        }
//        HorizontalDivider(color = MaterialTheme.colorScheme.secondaryContainer)
//    }
//}