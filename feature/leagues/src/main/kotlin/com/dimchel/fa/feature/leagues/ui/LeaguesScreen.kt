package com.dimchel.fa.feature.leagues.ui

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun LeaguesScreen(viewModel: LeaguesViewModel) {
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    when (uiState) {
        is LeaguesUiState.Loading -> LoadingState()
        is LeaguesUiState.Error -> ErrorState()
        is LeaguesUiState.Success -> SuccessState()
    }
}

@Composable
internal fun LoadingState() {
    CircularProgressIndicator()
}

@Composable
internal fun ErrorState() {
    // TODO: Implement this
}

@Composable
internal fun SuccessState() {
    Text(text = "Succcess")
}