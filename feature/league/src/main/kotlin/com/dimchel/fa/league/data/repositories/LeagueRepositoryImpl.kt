package com.dimchel.fa.league.data.repositories

import com.dimchel.core.data.daos.LeaguesDao
import com.dimchel.fa.league.data.api.LeagueApiService
import com.dimchel.fa.league.data.mappers.toEntity
import com.dimchel.fa.league.data.mappers.toModel
import com.dimchel.fa.league.domain.models.LeagueModel
import javax.inject.Inject

internal class LeagueRepositoryImpl @Inject constructor(
    private val apiService: LeagueApiService,
    private val dao: LeaguesDao,
) : LeagueRepository {

    override suspend fun getLeague(leagueCode: String): LeagueModel {
        val localData = dao.getLeague(leagueCode)
        return if (localData == null || localData.standings.isEmpty()) {
            fetch(leagueCode)
        } else {
            localData.toModel()
        }
    }

    private suspend fun fetch(leagueCode: String): LeagueModel =
        apiService.getLeague(leagueCode)
            .toModel()
            .also { leagueModel ->
                dao.insertCompetitors(leagueModel.standings.map { it.toEntity(leagueCode) })
            }
}