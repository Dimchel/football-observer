package com.dimchel.fa.league.data.repositories

import com.dimchel.fa.league.domain.models.LeagueModel

internal interface LeagueRepository {

    suspend fun getLeague(leagueCode: String): LeagueModel

}