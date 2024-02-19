package com.dimchel.fa.feature.leagues.data.repositories

import com.dimchel.fa.feature.leagues.data.api.LeaguesApiService
import com.dimchel.fa.feature.leagues.data.mappers.toModel
import com.dimchel.fa.feature.leagues.domain.SupportedLeagues
import com.dimchel.fa.feature.leagues.domain.models.LeagueModel
import javax.inject.Inject

internal class LeaguesRepositoryImpl @Inject constructor(
    private val apiService: LeaguesApiService,
) : LeaguesRepository {

    private var cachedLeaguesData: List<LeagueModel>? = null

    override suspend fun getLeagues(): List<LeagueModel> {
        return cachedLeaguesData ?: fetchLeagues()
    }

    private suspend fun fetchLeagues(): List<LeagueModel> =
        apiService.getLeaguesList()
            .leaguesList
            .filter { SupportedLeagues.SUPPORTED_LEAGUES.contains(it.code) }
            .map { it.toModel() }
            .also { cachedLeaguesData = it }
}