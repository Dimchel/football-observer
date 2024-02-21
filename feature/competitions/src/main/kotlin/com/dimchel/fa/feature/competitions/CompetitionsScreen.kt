package com.dimchel.fa.feature.competitions

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.dimchel.fa.core.common.architecture.application
import com.dimchel.fa.core.common.architecture.daggerViewModel
import com.dimchel.fa.feature.competitions.di.CompetitionsDependencyProvider
import com.dimchel.fa.feature.competitions.di.CompetitionsStartParams
import com.dimchel.fa.feature.competitions.presentation.CompetitionsUiState
import com.dimchel.fa.feature.competitions.presentation.CompetitionsViewModel
import com.dimchel.fa.feature.competitions.presentation.ErrorState
import com.dimchel.fa.feature.competitions.presentation.LoadingState
import com.dimchel.fa.feature.competitions.presentation.SuccessState

object CompetitionsScreen : Screen {

    @Composable
    override fun Content() {
        val application = application()
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: CompetitionsViewModel = daggerViewModel {
            CompetitionsDependencyProvider.provide(
                application,
                CompetitionsStartParams(navigator),
            ).getViewModel()
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