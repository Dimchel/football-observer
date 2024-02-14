package com.dimchel.fa.feature.leagues.data.mappers

import com.dimchel.fa.feature.leagues.data.schemes.LeagueScheme
import com.dimchel.fa.feature.leagues.domain.models.LeagueModel

internal fun LeagueScheme.toModel() = LeagueModel(
    id = id,
    name = name,
    lastUpdated = lastUpdated,
)