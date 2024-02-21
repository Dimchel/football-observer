package com.dimchel.fa.feature.competitions.domain.models

internal data class CompetitionModel(
    val id: Int,
    val name: String,
    val code: String,
    val lastUpdated: String,
    val emblemUrl: String?,
)