package com.dimchel.fa.feature.league.impl.presentation

import com.dimchel.fa.core.common.architecture.UiState
import com.dimchel.fa.feature.league.impl.models.CompetitorModel
import com.dimchel.fa.feature.league.impl.models.LeagueInfoModel

internal sealed interface LeagueUiState : UiState {

    data object Loading : LeagueUiState

    data class Success(
        val leagueInfo: LeagueInfoModel,
        val standings: List<CompetitorModel>,
    ) : LeagueUiState

    data object Error : LeagueUiState
}