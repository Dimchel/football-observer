package com.dimchel.fa.league.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimchel.fa.core.common.utils.klog
import com.dimchel.fa.league.data.repositories.LeagueRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class LeagueViewModel @Inject constructor(
    private val repository: LeagueRepository
) : ViewModel() {

    private val mutableUiState: MutableStateFlow<LeagueUiState> =
        MutableStateFlow(LeagueUiState.Loading)
    val uiState: StateFlow<LeagueUiState> = mutableUiState

    init {
        viewModelScope.launch {
            val leagueData = repository.getLeague("PL")
            mutableUiState.update {
                LeagueUiState.Success(leagueData.competition, leagueData.standings)
            }
        }
    }

    fun onLeagueClicked(leagueId: Int) {
        klog("onLeagueClicked: $leagueId")
    }
}