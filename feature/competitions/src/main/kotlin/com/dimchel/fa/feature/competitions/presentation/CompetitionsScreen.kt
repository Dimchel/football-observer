package com.dimchel.fa.feature.competitions.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import com.dimchel.fa.core.common.architecture.application
import com.dimchel.fa.core.common.architecture.daggerViewModel
import com.dimchel.fa.feature.competitions.di.CompetitionsDependencyProvider

object CompetitionsScreen : Screen {

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