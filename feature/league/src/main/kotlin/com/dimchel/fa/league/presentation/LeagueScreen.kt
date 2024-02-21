package com.dimchel.fa.league.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import com.dimchel.fa.core.common.architecture.application
import com.dimchel.fa.core.common.architecture.daggerViewModel
import com.dimchel.fa.league.di.LeagueDependencyProvider

internal object LeagueScreen : Screen {

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