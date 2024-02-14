package com.dimchel.fa.feature.leagues.data.repositories

import com.dimchel.fa.feature.leagues.domain.models.LeagueModel

internal interface LeaguesRepository {

    suspend fun getLeagues() : List<LeagueModel>

}