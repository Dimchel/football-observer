package com.dimchel.fa.feature.competitions.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.navigator.Navigator
import com.dimchel.fa.core.common.architecture.DataResult
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
) : ViewModel() {

    private lateinit var navigator: Navigator

    private val mutableUiState: MutableStateFlow<CompetitionsUiState> =
        MutableStateFlow(CompetitionsUiState.Loading)
    val uiState: StateFlow<CompetitionsUiState> = mutableUiState

    init {
        tryToLoadData()
    }

    override fun onCleared() {
        CompetitionsDependencyProvider.release()
    }

    fun setNavigator(navigator: Navigator) {
        this.navigator = navigator
    }

    fun onCompetitionClicked(leagueId: String) {
        navigator.push(LeagueScreen(LeagueStartParams(leagueId)))
    }

    fun onRetryClicked() {
        tryToLoadData()
    }

    private fun tryToLoadData() {
        mutableUiState.update { CompetitionsUiState.Loading }

        viewModelScope.launch {
            val resultedUiState = when (val getCompetitionsResult = repository.getCompetitions()) {
                is DataResult.Success -> CompetitionsUiState.Success(getCompetitionsResult.result)
                is DataResult.Failure -> CompetitionsUiState.Error
            }
            mutableUiState.update { resultedUiState }
        }
    }
}