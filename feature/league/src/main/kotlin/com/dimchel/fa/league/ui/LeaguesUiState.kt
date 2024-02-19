package com.dimchel.fa.league.ui

import com.dimchel.fa.core.common.architecture.UiState
import com.dimchel.fa.league.domain.models.CompetitorModel
import com.dimchel.fa.league.domain.models.LeagueInfoModel

internal sealed interface LeaguesUiState : UiState {

    data object Loading : LeaguesUiState

    data class Success(
        val leagueInfo: LeagueInfoModel,
        val standings: List<CompetitorModel>,
    ) : LeaguesUiState

    data object Error : LeaguesUiState
}