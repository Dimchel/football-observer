package com.dimchel.fa.feature.competitions.data.repositories

import com.dimchel.core.data.daos.CompetitionsDao
import com.dimchel.fa.feature.competitions.data.api.CompetitionsApiService
import com.dimchel.fa.feature.competitions.data.mappers.toEntity
import com.dimchel.fa.feature.competitions.data.mappers.toModel
import com.dimchel.fa.feature.competitions.domain.models.CompetitionModel
import javax.inject.Inject

internal class CompetitionsRepositoryImpl @Inject constructor(
    private val apiService: CompetitionsApiService,
    private val dao: CompetitionsDao,
) : CompetitionsRepository {

    override suspend fun getCompetitions(): List<CompetitionModel> {
        val localData = dao.getAll()
        return if (localData.isEmpty()) {
            fetch()
        } else {
            localData.map { it.toModel() }
        }
    }

    private suspend fun fetch(): List<CompetitionModel> =
        apiService.getCompetitionsList()
            .competitionsList
            .map { it.toModel() }
            .also { competitions ->
                dao.deleteAll()
                dao.insertAll(competitions.map { it.toEntity() })
            }
}