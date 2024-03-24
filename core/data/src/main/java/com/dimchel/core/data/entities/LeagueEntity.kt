package com.dimchel.core.data.entities

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation

data class LeagueEntity(
    @Embedded val competition: CompetitionEntity,
    @Relation(
        parentColumn = "code",
        entityColumn = "league_code"
    )
    val standings: List<CompetitorEntity>,
)

@Entity(tableName = "competitor")
data class CompetitorEntity(
    @PrimaryKey
    @Embedded val team: TeamEntity,

    @ColumnInfo(name = "league_code") val leagueCode: String,
    @ColumnInfo(name = "position") val position: Int,
    @ColumnInfo(name = "played_games") val playedGames: Int,
    @ColumnInfo(name = "won") val won: Int,
    @ColumnInfo(name = "draw") val draw: Int,
    @ColumnInfo(name = "lost") val lost: Int,
    @ColumnInfo(name = "points") val points: Int,
    @ColumnInfo(name = "goals_for") val goalsFor: Int,
    @ColumnInfo(name = "goals_against") val goalsAgainst: Int,
    @ColumnInfo(name = "goal_difference") val goalDifference: Int,
)

data class TeamEntity(
    @PrimaryKey
    @ColumnInfo(name = "team_id") val teamId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "short_name") val shortName: String,
    @ColumnInfo(name = "crest_url") val crestUrl: String,
)