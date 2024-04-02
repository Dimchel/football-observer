package com.dimchel.fa.league

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import com.dimchel.fa.core.common.architecture.application
import com.dimchel.fa.core.common.architecture.daggerViewModel
import com.dimchel.fa.feature.league.impl.di.LeagueDependencyProvider
import com.dimchel.fa.feature.league.impl.di.LeagueStartParams
import com.dimchel.fa.feature.league.impl.presentation.ErrorState
import com.dimchel.fa.feature.league.impl.presentation.LeagueUiState
import com.dimchel.fa.feature.league.impl.presentation.LeagueViewModel
import com.dimchel.fa.feature.league.impl.presentation.LoadingState
import com.dimchel.fa.feature.league.impl.presentation.SuccessState

class LeagueScreen(private val leagueStartParams: LeagueStartParams) : Screen {

    @Composable
    override fun Content() {
        val application = application()
        val viewModel: LeagueViewModel = daggerViewModel {
            LeagueDependencyProvider.provide(application, leagueStartParams).getViewModel()
        }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        when (val state = uiState) {
            is LeagueUiState.Loading -> LoadingState()
            is LeagueUiState.Error -> ErrorState(onRetryClicked = { viewModel.onRetryClicked() })
            is LeagueUiState.Success -> SuccessState(state.standings)
        }
    }
}