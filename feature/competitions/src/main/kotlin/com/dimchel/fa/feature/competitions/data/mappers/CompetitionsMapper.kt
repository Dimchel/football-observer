package com.dimchel.fa.feature.competitions.data.mappers

import com.dimchel.fa.feature.competitions.data.schemes.CompetitionScheme
import com.dimchel.fa.feature.competitions.domain.models.CompetitionModel

internal fun CompetitionScheme.toModel() = CompetitionModel(
    id = id,
    name = name,
    lastUpdated = lastUpdated,
    emblemUrl = emblemUrl,
)