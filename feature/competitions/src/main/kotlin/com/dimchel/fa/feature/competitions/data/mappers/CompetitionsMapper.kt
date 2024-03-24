package com.dimchel.fa.feature.competitions.data.mappers

import com.dimchel.core.data.entities.CompetitionEntity
import com.dimchel.fa.feature.competitions.data.schemes.CompetitionScheme
import com.dimchel.fa.feature.competitions.domain.models.CompetitionModel

internal fun CompetitionScheme.toModel() = CompetitionModel(
    id = id,
    name = name,
    code = code,
    lastUpdated = lastUpdated,
    emblemUrl = emblemUrl,
)

internal fun CompetitionEntity.toModel() = CompetitionModel(
    id = id,
    name = name,
    code = code,
    lastUpdated = lastUpdated,
    emblemUrl = emblemUrl,
)

internal fun CompetitionModel.toEntity() = CompetitionEntity(
    id = id,
    name = name,
    code = code,
    lastUpdated = lastUpdated,
    emblemUrl = emblemUrl,
)