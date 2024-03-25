package com.dimchel.fa.league.data.datasources

import com.dimchel.fa.core.common.architecture.DataResult
import com.dimchel.fa.core.network.safeApiCall
import com.dimchel.fa.league.data.api.LeagueApiService
import com.dimchel.fa.league.data.schemes.LeagueScheme
import javax.inject.Inject

internal class LeagueNetworkDataSource @Inject constructor(
    private val apiService: LeagueApiService
) {
    internal suspend fun fetchLeague(leagueCode: String): DataResult<LeagueScheme> =
        safeApiCall { apiService.getLeague(leagueCode) }
}