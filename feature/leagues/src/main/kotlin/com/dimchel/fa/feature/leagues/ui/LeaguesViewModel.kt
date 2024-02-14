package com.dimchel.fa.feature.leagues.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimchel.fa.core.common.utils.klog
import com.dimchel.fa.feature.leagues.data.repositories.LeaguesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class LeaguesViewModel @Inject constructor(
    private val repository: LeaguesRepository
) : ViewModel() {

    private val mutableUiState: MutableStateFlow<LeaguesUiState> =
        MutableStateFlow(LeaguesUiState.Loading)
    val uiState: StateFlow<LeaguesUiState> = mutableUiState

    init {
        viewModelScope.launch {
            mutableUiState.update { LeaguesUiState.Success(repository.getLeagues()) }
        }
    }

    fun onLeagueClicked(leagueId: Int) {
        klog("onLeagueClicked: $leagueId")
    }
}