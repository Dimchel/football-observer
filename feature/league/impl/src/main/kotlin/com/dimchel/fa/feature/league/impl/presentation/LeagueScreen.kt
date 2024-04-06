package com.dimchel.fa.feature.league.impl.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import com.dimchel.fa.core.common.architecture.daggerViewModel
import com.dimchel.fa.feature.league.impl.presentation.ErrorState
import com.dimchel.fa.feature.league.impl.presentation.LeagueUiState
import com.dimchel.fa.feature.league.impl.presentation.LeagueViewModel
import com.dimchel.fa.feature.league.impl.presentation.LoadingState
import com.dimchel.fa.feature.league.impl.presentation.SuccessState
import javax.inject.Inject

internal class LeagueScreen @Inject constructor(
    private val viewModel: LeagueViewModel,
) : Screen {

    @Composable
    override fun Content() {
        val viewModel: LeagueViewModel = daggerViewModel { viewModel }
        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        when (val state = uiState) {
            is LeagueUiState.Loading -> LoadingState()
            is LeagueUiState.Error -> ErrorState(onRetryClicked = { viewModel.onRetryClicked() })
            is LeagueUiState.Success -> SuccessState(state.standings)
        }
    }
}