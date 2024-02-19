package com.dimchel.fa.feature.competitions.data.repositories

import com.dimchel.fa.feature.competitions.domain.models.CompetitionModel

internal interface CompetitionsRepository {

    suspend fun getCompetitions() : List<CompetitionModel>

}