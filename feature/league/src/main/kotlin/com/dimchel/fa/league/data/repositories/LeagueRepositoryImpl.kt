package com.dimchel.fa.league.data.repositories

import com.dimchel.fa.league.data.api.LeagueApiService
import com.dimchel.fa.league.data.mappers.mapToModel
import com.dimchel.fa.league.domain.models.LeagueModel
import javax.inject.Inject

internal class LeagueRepositoryImpl @Inject constructor(
    private val apiService: LeagueApiService,
) : LeagueRepository {

    private var cachedData: LeagueModel? = null

    override suspend fun getLeague(leagueCode: String): LeagueModel {
        return cachedData ?: fetchLeague(leagueCode)
    }

    private suspend fun fetchLeague(leagueCode: String): LeagueModel =
        apiService.getLeague(leagueCode)
            .mapToModel()
            .also { cachedData = it }
}