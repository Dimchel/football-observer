package com.dimchel.fa.feature.league.impl.data.datasources

import com.dimchel.fa.core.common.architecture.DataResult
import com.dimchel.fa.core.network.safeApiCall
import com.dimchel.fa.feature.league.impl.data.api.LeagueApiService
import com.dimchel.fa.feature.league.impl.data.schemes.LeagueScheme
import javax.inject.Inject

internal class LeagueNetworkDataSource @Inject constructor(
    private val apiService: LeagueApiService
) {
    internal suspend fun fetchLeague(leagueCode: String): DataResult<LeagueScheme> =
        safeApiCall { apiService.getLeague(leagueCode) }
}