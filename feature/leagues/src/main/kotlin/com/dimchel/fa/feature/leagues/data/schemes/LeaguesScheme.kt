package com.dimchel.fa.feature.leagues.data.schemes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class LeaguesScheme(
    @SerialName("competitions") val leaguesList: List<LeagueScheme>
)

@Serializable
internal class LeagueScheme(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("lastUpdated") val lastUpdated: String,
)