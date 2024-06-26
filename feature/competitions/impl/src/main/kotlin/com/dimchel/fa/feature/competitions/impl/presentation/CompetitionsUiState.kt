package com.dimchel.fa.feature.competitions.impl.presentation

import com.dimchel.fa.core.common.architecture.UiState
import com.dimchel.fa.feature.competitions.impl.domain.models.CompetitionModel

internal sealed interface CompetitionsUiState : UiState {

    data object Loading : CompetitionsUiState

    data class Success(val competitionsList: List<CompetitionModel>) : CompetitionsUiState

    data object Error : CompetitionsUiState
}