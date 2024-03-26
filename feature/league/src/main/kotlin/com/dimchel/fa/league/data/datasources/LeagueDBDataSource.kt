package com.dimchel.fa.league.data.datasources

import com.dimchel.core.data.daos.LeaguesDao
import com.dimchel.core.data.entities.CompetitorEntity
import com.dimchel.core.data.entities.LeagueEntity
import javax.inject.Inject

internal class LeagueDBDataSource @Inject constructor(
    private val leaguesDao: LeaguesDao,
) {
    internal suspend fun getLeague(code: String): LeagueEntity? = leaguesDao.getLeague(code)

    internal suspend fun saveLeague(competitors: List<CompetitorEntity>) =
        leaguesDao.insertCompetitors(competitors)
}