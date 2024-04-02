package com.dimchel.fa.feature.league.impl.models

internal class LeagueModel(
    val competition: LeagueInfoModel,
    val standings: List<CompetitorModel>,
)

internal class LeagueInfoModel(
    val id: Int,
    val name: String,
    val emblemUrl: String?,
)

internal class CompetitorModel(
    val position: Int,
    val team: TeamModel,
    val playedGames: Int,
    val won: Int,
    val draw: Int,
    val lost: Int,
    val points: Int,
    val goalsFor: Int,
    val goalsAgainst: Int,
    val goalDifference: Int,
)

internal class TeamModel(
    val id: Int,
    val name: String,
    val shortName: String,
    val crestUrl: String,
)