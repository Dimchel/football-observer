package com.dimchel.fa.league.data.mappers

import com.dimchel.fa.league.data.schemes.CompetitorScheme
import com.dimchel.fa.league.data.schemes.LeagueInfoScheme
import com.dimchel.fa.league.data.schemes.LeagueScheme
import com.dimchel.fa.league.data.schemes.TeamScheme
import com.dimchel.fa.league.domain.models.CompetitorModel
import com.dimchel.fa.league.domain.models.LeagueInfoModel
import com.dimchel.fa.league.domain.models.LeagueModel
import com.dimchel.fa.league.domain.models.TeamModel

internal fun LeagueScheme.mapToModel() = LeagueModel(
    competition = competition.mapToModel(),
    standings = standings.first().table.map { it.mapToModel() }
)

internal fun LeagueInfoScheme.mapToModel() = LeagueInfoModel(id, name, emblemUrl)

internal fun CompetitorScheme.mapToModel() = CompetitorModel(
    position,
    team.mapToModel(),
    playedGames,
    won,
    draw,
    lost,
    points,
    goalsFor,
    goalsAgainst,
    goalDifference,
)

internal fun TeamScheme.mapToModel() = TeamModel(id, name, shortName, crestUrl)