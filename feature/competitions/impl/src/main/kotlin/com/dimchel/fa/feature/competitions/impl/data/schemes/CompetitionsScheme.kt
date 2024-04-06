package com.dimchel.fa.feature.competitions.impl.data.schemes

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal class CompetitionsScheme(
    @SerialName("competitions") val competitionsList: List<CompetitionScheme>
)

@Serializable
internal class CompetitionScheme(
    @SerialName("id") val id: Int,
    @SerialName("name") val name: String,
    @SerialName("code") val code: String,
    @SerialName("lastUpdated") val lastUpdated: String,
    @SerialName("emblem") val emblemUrl: String?,
)