package com.dimchel.fa.feature.competitions.impl.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.navigator.Navigator
import com.dimchel.fa.core.common.architecture.DataResult
import com.dimchel.fa.feature.competitions.impl.data.repositories.CompetitionsRepository
import com.dimchel.fa.feature.competitions.impl.di.CompetitionsDepsProviderImpl
import com.dimchel.fa.feature.league.api.presentation.LeagueScreenProvider
import com.dimchel.fa.feature.league.api.presentation.LeagueScreenStartParams
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Provider

internal class CompetitionsViewModel @Inject constructor(
    private val repository: CompetitionsRepository,
    private val leagueScreenProvider: Provider<LeagueScreenProvider>,
) : ViewModel() {

    private lateinit var navigator: Navigator

    private val mutableUiState: MutableStateFlow<CompetitionsUiState> =
        MutableStateFlow(CompetitionsUiState.Loading)
    val uiState: StateFlow<CompetitionsUiState> = mutableUiState

    init {
        tryToLoadData()
    }

    override fun onCleared() {
        CompetitionsDepsProviderImpl.release()
    }

    fun setNavigator(navigator: Navigator) {
        this.navigator = navigator
    }

    fun onCompetitionClicked(leagueId: String) {
        navigator.push(
            leagueScreenProvider.get().getLeagueScreen(LeagueScreenStartParams(leagueId))
        )
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