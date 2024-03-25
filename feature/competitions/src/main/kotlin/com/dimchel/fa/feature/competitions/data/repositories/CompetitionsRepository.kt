package com.dimchel.fa.feature.competitions.data.repositories

import com.dimchel.fa.core.common.architecture.DataResult
import com.dimchel.fa.feature.competitions.domain.models.CompetitionModel

internal interface CompetitionsRepository {

    suspend fun getCompetitions() : DataResult<List<CompetitionModel>>

}