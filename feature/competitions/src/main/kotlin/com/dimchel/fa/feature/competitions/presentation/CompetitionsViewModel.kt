package com.dimchel.fa.feature.competitions.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.navigator.Navigator
import com.dimchel.fa.feature.competitions.data.repositories.CompetitionsRepository
import com.dimchel.fa.feature.competitions.di.CompetitionsDependencyProvider
import com.dimchel.fa.league.LeagueScreen
import com.dimchel.fa.league.di.LeagueStartParams
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class CompetitionsViewModel @Inject constructor(
    private val repository: CompetitionsRepository,
    private val navigator: Navigator,
) : ViewModel() {

    private val mutableUiState: MutableStateFlow<CompetitionsUiState> =
        MutableStateFlow(CompetitionsUiState.Loading)
    val uiState: StateFlow<CompetitionsUiState> = mutableUiState

    init {
        viewModelScope.launch {
            mutableUiState.update { CompetitionsUiState.Success(repository.getCompetitions()) }
        }
    }

    fun onCompetitionClicked(leagueId: String) {
        navigator.push(LeagueScreen(LeagueStartParams(leagueId)))
    }

    override fun onCleared() {
        CompetitionsDependencyProvider.release()
    }
}