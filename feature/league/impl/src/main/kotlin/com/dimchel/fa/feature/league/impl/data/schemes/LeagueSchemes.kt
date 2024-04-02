package com.dimchel.fa.feature.league.impl.data.schemes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class LeagueScheme(
    @SerialName("competition") val competition: LeagueInfoScheme,
    @SerialName("standings") val standings: List<StandingScheme>,
)

@Serializable
internal class LeagueInfoScheme(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("emblem") val emblemUrl: String,
)

@Serializable
internal class StandingScheme(
    @SerialName("table") val table: List<CompetitorScheme>,
)

@Serializable
internal class CompetitorScheme(
    @SerialName("position") val position: Int,
    @SerialName("team") val team: TeamScheme,
    @SerialName("playedGames") val playedGames: Int,
    @SerialName("won") val won: Int,
    @SerialName("draw") val draw: Int,
    @SerialName("lost") val lost: Int,
    @SerialName("points") val points: Int,
    @SerialName("goalsFor") val goalsFor: Int,
    @SerialName("goalsAgainst") val goalsAgainst: Int,
    @SerialName("goalDifference") val goalDifference: Int,
)

@Serializable
internal class TeamScheme(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("shortName") val shortName: String,
    @SerialName("crest") val crestUrl: String,
)