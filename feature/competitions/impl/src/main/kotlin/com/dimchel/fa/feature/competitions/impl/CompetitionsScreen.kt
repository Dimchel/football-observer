package com.dimchel.fa.feature.competitions.impl

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.dimchel.fa.core.common.architecture.daggerViewModel
import com.dimchel.fa.feature.competitions.impl.presentation.CompetitionsUiState
import com.dimchel.fa.feature.competitions.impl.presentation.CompetitionsViewModel
import com.dimchel.fa.feature.competitions.impl.presentation.ErrorState
import com.dimchel.fa.feature.competitions.impl.presentation.LoadingState
import com.dimchel.fa.feature.competitions.impl.presentation.SuccessState
import javax.inject.Inject

internal class CompetitionsScreen @Inject constructor(
    private val viewModel: CompetitionsViewModel,
) : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel: CompetitionsViewModel = daggerViewModel { viewModel }
            .apply { setNavigator(navigator) }

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()
        when (val state = uiState) {
            is CompetitionsUiState.Loading -> LoadingState()
            is CompetitionsUiState.Error -> ErrorState(
                onRetryClicked = { viewModel.onRetryClicked() }
            )
            is CompetitionsUiState.Success -> SuccessState(
                state.competitionsList,
                onCompetitionClicked = { viewModel.onCompetitionClicked(it.code) }
            )
        }
    }
}