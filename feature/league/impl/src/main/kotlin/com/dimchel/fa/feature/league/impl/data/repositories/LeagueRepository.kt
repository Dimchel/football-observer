package com.dimchel.fa.feature.league.impl.data.repositories

import com.dimchel.fa.core.common.architecture.DataResult
import com.dimchel.fa.feature.league.impl.models.LeagueModel

internal interface LeagueRepository {

    suspend fun getLeague(leagueCode: String): DataResult<LeagueModel>

}