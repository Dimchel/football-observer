package com.dimchel.fa.league.data.repositories

import com.dimchel.fa.core.common.architecture.DataResult
import com.dimchel.fa.core.common.architecture.alsoSuccess
import com.dimchel.fa.core.common.architecture.mapFailure
import com.dimchel.fa.core.common.architecture.mapSuccess
import com.dimchel.fa.league.data.datasources.LeagueDBDataSource
import com.dimchel.fa.league.data.datasources.LeagueNetworkDataSource
import com.dimchel.fa.league.data.mappers.toEntity
import com.dimchel.fa.league.data.mappers.toModel
import com.dimchel.fa.league.domain.models.LeagueModel
import javax.inject.Inject

internal class LeagueRepositoryImpl @Inject constructor(
    private val networkDataSource: LeagueNetworkDataSource,
    private val dbDataSource: LeagueDBDataSource,
) : LeagueRepository {

    override suspend fun getLeague(leagueCode: String): DataResult<LeagueModel> {
        return fetch(leagueCode).mapFailure { loadFromDb(leagueCode) }
    }

    private suspend fun fetch(leagueCode: String): DataResult<LeagueModel> =
        networkDataSource.fetchLeague(leagueCode)
            .mapSuccess {
                it.toModel()
            }
            .alsoSuccess { result ->
                dbDataSource.saveLeague(
                    competitors = result.standings.map { it.toEntity(leagueCode) }
                )
            }

    private suspend fun loadFromDb(leagueCode: String): DataResult<LeagueModel> =
        dbDataSource.getLeague(leagueCode)
            .mapSuccess { it.toModel() }
}