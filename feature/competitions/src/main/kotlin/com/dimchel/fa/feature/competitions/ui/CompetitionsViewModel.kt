package com.dimchel.fa.feature.competitions.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimchel.fa.core.common.utils.klog
import com.dimchel.fa.feature.competitions.data.repositories.CompetitionsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class CompetitionsViewModel @Inject constructor(
    private val repository: CompetitionsRepository
) : ViewModel() {

    private val mutableUiState: MutableStateFlow<CompetitionsUiState> =
        MutableStateFlow(CompetitionsUiState.Loading)
    val uiState: StateFlow<CompetitionsUiState> = mutableUiState

    init {
        viewModelScope.launch {
            mutableUiState.update { CompetitionsUiState.Success(repository.getCompetitions()) }
        }
    }

    fun onLeagueClicked(leagueId: Int) {
        klog("onLeagueClicked: $leagueId")
    }
}