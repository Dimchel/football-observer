package com.dimchel.fa.league.data.datasources

import com.dimchel.core.data.daos.LeaguesDao
import com.dimchel.core.data.entities.CompetitorEntity
import com.dimchel.core.data.entities.LeagueEntity
import com.dimchel.fa.core.common.architecture.DataResult
import javax.inject.Inject

internal class LeagueDBDataSource @Inject constructor(
    private val leaguesDao: LeaguesDao,
) {
    internal suspend fun getLeague(code: String): DataResult<LeagueEntity> {
        val result = leaguesDao.getLeague(code)

        return if (result == null || result.standings.isEmpty()) {
            DataResult.Failure
        } else {
            DataResult.Success(result)
        }
    }

    internal suspend fun saveLeague(competitors: List<CompetitorEntity>) =
        leaguesDao.insertCompetitors(competitors)
}