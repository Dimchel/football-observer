package com.dimchel.fa.feature.league.impl.data.mappers

import com.dimchel.core.data.entities.CompetitionEntity
import com.dimchel.core.data.entities.CompetitorEntity
import com.dimchel.core.data.entities.LeagueEntity
import com.dimchel.core.data.entities.TeamEntity
import com.dimchel.fa.feature.league.impl.data.schemes.CompetitorScheme
import com.dimchel.fa.feature.league.impl.data.schemes.LeagueInfoScheme
import com.dimchel.fa.feature.league.impl.data.schemes.LeagueScheme
import com.dimchel.fa.feature.league.impl.data.schemes.TeamScheme
import com.dimchel.fa.feature.league.impl.models.CompetitorModel
import com.dimchel.fa.feature.league.impl.models.LeagueInfoModel
import com.dimchel.fa.feature.league.impl.models.LeagueModel
import com.dimchel.fa.feature.league.impl.models.TeamModel

internal fun LeagueScheme.toModel() = LeagueModel(
    competition = competition.toModel(),
    standings = standings.first().table.map { it.toModel() }
)
internal fun LeagueEntity.toModel() = LeagueModel(
    competition = competition.toModel(),
    standings = standings.map { it.toModel() }
)

internal fun LeagueInfoScheme.toModel() = LeagueInfoModel(id, name, emblemUrl)
internal fun CompetitionEntity.toModel() = LeagueInfoModel(id, name, emblemUrl)


internal fun CompetitorEntity.toModel() = CompetitorModel(
    position,
    team.toModel(),
    playedGames,
    won,
    draw,
    lost,
    points,
    goalsFor,
    goalsAgainst,
    goalDifference,
)
internal fun CompetitorScheme.toModel() = CompetitorModel(
    position,
    team.toModel(),
    playedGames,
    won,
    draw,
    lost,
    points,
    goalsFor,
    goalsAgainst,
    goalDifference,
)
internal fun CompetitorModel.toEntity(leagueCode: String) = CompetitorEntity(
    team.toEntity(),
    leagueCode = leagueCode,
    position,
    playedGames,
    won,
    draw,
    lost,
    points,
    goalsFor,
    goalsAgainst,
    goalDifference,
)

internal fun TeamScheme.toModel() = TeamModel(id, name, shortName, crestUrl)
internal fun TeamEntity.toModel() = TeamModel(teamId, name, shortName, crestUrl)
internal fun TeamModel.toEntity() = TeamEntity(id, name, shortName, crestUrl)
