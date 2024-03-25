package com.dimchel.fa.league.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimchel.fa.core.common.architecture.DataResult
import com.dimchel.fa.core.common.utils.klog
import com.dimchel.fa.league.data.repositories.LeagueRepository
import com.dimchel.fa.league.di.LeagueDependencyProvider
import com.dimchel.fa.league.di.LeagueStartParams
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class LeagueViewModel @Inject constructor(
    private val leagueStartParams: LeagueStartParams,
    private val repository: LeagueRepository
) : ViewModel() {

    private val mutableUiState: MutableStateFlow<LeagueUiState> =
        MutableStateFlow(LeagueUiState.Loading)
    val uiState: StateFlow<LeagueUiState> = mutableUiState

    init {
        viewModelScope.launch {
            val leagueData = repository.getLeague(leagueStartParams.leagueCode)
            val resultedState = when (leagueData) {
                is DataResult.Success -> {
                    LeagueUiState.Success(leagueData.result.competition, leagueData.result.standings)
                }
                is DataResult.Failure -> {
                    LeagueUiState.Error
                }
            }
            mutableUiState.update { resultedState }
        }
    }

    fun onLeagueClicked(leagueId: Int) {
        klog("onLeagueClicked: $leagueId")
    }

    override fun onCleared() {
        LeagueDependencyProvider.release()
    }
}