package com.dimchel.fa.league.data.repositories

import com.dimchel.fa.league.data.schemes.LeagueScheme

internal interface LeagueRepository {

    suspend fun getLeague(leagueCode: String): LeagueScheme

}