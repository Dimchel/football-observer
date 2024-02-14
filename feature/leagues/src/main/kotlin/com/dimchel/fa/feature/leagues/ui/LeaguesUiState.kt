package com.dimchel.fa.feature.leagues.ui

import com.dimchel.fa.core.common.architecture.UiState
import com.dimchel.fa.feature.leagues.domain.models.LeagueModel

internal sealed interface LeaguesUiState : UiState {

    data object Loading : LeaguesUiState

    data class Success(val leaguesList: List<LeagueModel>) : LeaguesUiState

    data object Error : LeaguesUiState
}