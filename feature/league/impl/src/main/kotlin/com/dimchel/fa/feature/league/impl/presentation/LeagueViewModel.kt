package com.dimchel.fa.feature.league.impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimchel.fa.core.common.architecture.DataResult
import com.dimchel.fa.core.common.utils.klog
import com.dimchel.fa.feature.league.impl.data.repositories.LeagueRepository
import com.dimchel.fa.feature.league.impl.di.LeagueDependencyProvider
import com.dimchel.fa.feature.league.impl.di.LeagueStartParams
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
        tryToLoadData()
    }

    override fun onCleared() {
        LeagueDependencyProvider.release()
    }

    fun onLeagueClicked(leagueId: Int) {
        klog("onLeagueClicked: $leagueId")
    }

    fun onRetryClicked() {
        tryToLoadData()
    }

    private fun tryToLoadData() {
        mutableUiState.update { LeagueUiState.Loading }

        viewModelScope.launch {
            val getLeagueResult = repository.getLeague(leagueStartParams.leagueCode)
            val resultedState = when (getLeagueResult) {
                is DataResult.Success -> {
                    LeagueUiState.Success(
                        leagueInfo = getLeagueResult.result.competition,
                        standings = getLeagueResult.result.standings,
                    )
                }
                is DataResult.Failure -> {
                    LeagueUiState.Error
                }
            }
            mutableUiState.update { resultedState }
        }
    }
}