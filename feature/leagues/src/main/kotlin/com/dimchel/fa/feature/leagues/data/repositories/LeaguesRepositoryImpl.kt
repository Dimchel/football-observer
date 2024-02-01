package com.dimchel.fa.feature.leagues.data.repositories

import com.dimchel.fa.feature.leagues.data.api.LeaguesApiService
import com.dimchel.fa.feature.leagues.data.schemes.LeaguesScheme
import javax.inject.Inject

internal class LeaguesRepositoryImpl @Inject constructor(
    private val apiService: LeaguesApiService,
) : LeaguesRepository {

    override suspend fun getLeagues(): LeaguesScheme = apiService.getLeaguesList()

}