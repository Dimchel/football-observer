package com.dimchel.fa.feature.leagues.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dimchel.fa.feature.leagues.data.repositories.LeaguesRepository
import kotlinx.coroutines.launch
import javax.inject.Inject

internal class LeaguesViewModel @Inject constructor(
    private val repository: LeaguesRepository
) : ViewModel() {

    init {
        viewModelScope.launch {
            repository.getLeagues()
        }
    }
}