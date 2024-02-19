package com.dimchel.fa.league.data.repositories

import com.dimchel.fa.league.data.api.LeagueApiService
import com.dimchel.fa.league.data.schemes.LeagueScheme
import javax.inject.Inject

internal class LeagueRepositoryImpl @Inject constructor(
    private val apiService: LeagueApiService,
) : LeagueRepository {

//    private var cachedLeaguesData: List<LeagueModel>? = null

    override suspend fun getLeague(leagueCode: String): LeagueScheme {
//        return cachedLeaguesData ?: fetchLeagues()
        return apiService.getLeague(leagueCode)
    }

//    private suspend fun fetchLeagues(): List<LeagueModel> =
//        apiService.getLeaguesList()
//            .leaguesList
//            .filter { SupportedLeagues.SUPPORTED_LEAGUES.contains(it.code) }
//            .map { it.toModel() }
//            .also { cachedLeaguesData = it }
}