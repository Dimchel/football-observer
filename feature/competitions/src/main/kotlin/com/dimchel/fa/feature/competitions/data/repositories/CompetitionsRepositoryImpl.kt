package com.dimchel.fa.feature.competitions.data.repositories

import com.dimchel.fa.feature.competitions.data.api.CompetitionsApiService
import com.dimchel.fa.feature.competitions.data.mappers.toModel
import com.dimchel.fa.feature.competitions.domain.SupportedCompetitions
import com.dimchel.fa.feature.competitions.domain.models.CompetitionModel
import javax.inject.Inject

internal class CompetitionsRepositoryImpl @Inject constructor(
    private val apiService: CompetitionsApiService,
) : CompetitionsRepository {

    private var cachedData: List<CompetitionModel>? = null

    override suspend fun getCompetitions(): List<CompetitionModel> {
        return cachedData ?: fetch()
    }

    private suspend fun fetch(): List<CompetitionModel> =
        apiService.getCompetitionsList()
            .competitionsList
            .filter { SupportedCompetitions.SUPPORTED_COMPETITIONS.contains(it.code) }
            .map { it.toModel() }
            .also { cachedData = it }
}