package com.dimchel.fa.league.ui

import com.dimchel.fa.core.common.architecture.UiState

internal sealed interface LeaguesUiState : UiState {

    data object Loading : LeaguesUiState

//    data class Success(val leaguesList: List<LeagueModel>) : LeaguesUiState

    data object Error : LeaguesUiState
}