package com.dimchel.fa.feature.leagues.domain.models

internal data class LeagueModel(
    val id: Int,
    val name: String,
    val lastUpdated: String,
    val emblemUrl: String?,
)