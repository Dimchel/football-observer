package com.dimchel.fa.feature.competitions.data.repositories

import com.dimchel.core.data.daos.CompetitionsDao
import com.dimchel.fa.core.common.architecture.DataResult
import com.dimchel.fa.core.common.architecture.alsoSuccess
import com.dimchel.fa.core.common.architecture.mapSuccess
import com.dimchel.fa.feature.competitions.data.datasources.CompetitionsNetworkDataSource
import com.dimchel.fa.feature.competitions.data.mappers.toEntity
import com.dimchel.fa.feature.competitions.data.mappers.toModel
import com.dimchel.fa.feature.competitions.domain.models.CompetitionModel
import javax.inject.Inject

internal class CompetitionsRepositoryImpl @Inject constructor(
    private val networkDataSource: CompetitionsNetworkDataSource,
    private val dao: CompetitionsDao,
) : CompetitionsRepository {

    override suspend fun getCompetitions(): DataResult<List<CompetitionModel>> {
        val localData = dao.getAll()
        return if (localData.isEmpty()) {
            fetch()
        } else {
            DataResult.Success(localData.map { it.toModel() })
        }
    }

    private suspend fun fetch(): DataResult<List<CompetitionModel>> =
        networkDataSource.getCompetitionsList()
            .mapSuccess { scheme ->
                scheme.competitionsList.map { it.toModel() }
            }
            .alsoSuccess { competitions ->
                dao.deleteAll()
                dao.insertAll(competitions.map { it.toEntity() })
            }
}