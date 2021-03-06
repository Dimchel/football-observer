package com.dimchel.feature_competitions.data.repositories.mappers

import com.dimchel.core_network.schemes.responses.CompetitionScheme
import com.dimchel.core_network.schemes.responses.CompetitionerScheme
import com.dimchel.core_network.schemes.responses.LeagueScheme
import com.dimchel.feature_competitions.data.repositories.models.CompetitionModel
import com.dimchel.feature_competitions.data.repositories.models.CompetitionerModel
import com.dimchel.feature_competitions.data.repositories.models.LeagueModel

fun CompetitionScheme.mapToModel() =
    CompetitionModel(
        id,
        caption,
        league,
        year,
        currentMatchday,
        numberOfMatchdays,
        numberOfTeams,
        numberOfGames,
        lastUpdated
    )

fun CompetitionerScheme.mapToModel() =
    CompetitionerModel(
        rank,
        teamName,
        links.teamLink.href.substring(links.teamLink.href.lastIndexOf('/') + 1).toInt(),
        playedGames,
        crestURI,
        points,
        goals,
        goalsAgainst,
        goalDifference,
        wins,
        draws,
        losses
    )

fun LeagueScheme.mapToModel() =
    LeagueModel(
        leagueCaption,
        matchday,
        standing.map { it.mapToModel() }
    )
